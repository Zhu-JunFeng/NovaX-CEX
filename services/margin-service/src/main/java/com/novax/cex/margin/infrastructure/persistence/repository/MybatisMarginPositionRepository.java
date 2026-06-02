package com.novax.cex.margin.infrastructure.persistence.repository;

import com.novax.cex.margin.domain.model.MarginPosition;
import com.novax.cex.margin.domain.repository.MarginPositionRepository;
import com.novax.cex.margin.infrastructure.persistence.dataobject.MarginPositionDO;
import com.novax.cex.margin.infrastructure.persistence.mapper.MarginPositionMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisMarginPositionRepository implements MarginPositionRepository {
    private final MarginPositionMapper mapper;

    public MybatisMarginPositionRepository(MarginPositionMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public MarginPosition save(MarginPosition aggregate) {
        MarginPositionDO aggregateDO = toDO(aggregate);
        if (aggregateDO.getId() == null) {
            mapper.insert(aggregateDO);
        } else {
            mapper.updateById(aggregateDO);
        }
        return toDomain(aggregateDO);
    }

    @Override
    public Optional<MarginPosition> findById(String id) {
        return Optional.ofNullable(mapper.selectById(id)).map(this::toDomain);
    }

    @Override
    public List<MarginPosition> findAll() {
        return mapper.selectList(null).stream().map(this::toDomain).toList();
    }

    private MarginPositionDO toDO(MarginPosition aggregate) {
        MarginPositionDO aggregateDO = new MarginPositionDO();
        aggregateDO.setAccountId(aggregate.accountId());
        aggregateDO.setSymbolCode(aggregate.symbolCode());
        aggregateDO.setBorrowedAmount(aggregate.borrowedAmount());
        aggregateDO.setHealthStatus(aggregate.healthStatus());
        return aggregateDO;
    }

    private MarginPosition toDomain(MarginPositionDO record) {
        return new MarginPosition(
                record.getAccountId(),
                record.getSymbolCode(),
                record.getBorrowedAmount(),
                record.getHealthStatus()
        );
    }
}
