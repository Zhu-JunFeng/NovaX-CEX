package com.novax.cex.admin.infrastructure.persistence.repository;

import com.novax.cex.admin.domain.model.AdminOperator;
import com.novax.cex.admin.domain.repository.AdminOperatorRepository;
import com.novax.cex.admin.infrastructure.persistence.dataobject.AdminOperatorDO;
import com.novax.cex.admin.infrastructure.persistence.mapper.AdminOperatorMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisAdminOperatorRepository implements AdminOperatorRepository {
    private final AdminOperatorMapper mapper;

    public MybatisAdminOperatorRepository(AdminOperatorMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public AdminOperator save(AdminOperator aggregate) {
        AdminOperatorDO aggregateDO = toDO(aggregate);
        if (aggregateDO.getId() == null) {
            mapper.insert(aggregateDO);
        } else {
            mapper.updateById(aggregateDO);
        }
        return toDomain(aggregateDO);
    }

    @Override
    public Optional<AdminOperator> findById(String id) {
        return Optional.ofNullable(mapper.selectById(id)).map(this::toDomain);
    }

    @Override
    public List<AdminOperator> findAll() {
        return mapper.selectList(null).stream().map(this::toDomain).toList();
    }

    private AdminOperatorDO toDO(AdminOperator aggregate) {
        AdminOperatorDO aggregateDO = new AdminOperatorDO();
        aggregateDO.setOperatorNo(aggregate.operatorNo());
        aggregateDO.setDisplayName(aggregate.displayName());
        aggregateDO.setRoleCode(aggregate.roleCode());
        aggregateDO.setStatus(aggregate.status());
        return aggregateDO;
    }

    private AdminOperator toDomain(AdminOperatorDO record) {
        return new AdminOperator(
                record.getOperatorNo(),
                record.getDisplayName(),
                record.getRoleCode(),
                record.getStatus()
        );
    }
}
