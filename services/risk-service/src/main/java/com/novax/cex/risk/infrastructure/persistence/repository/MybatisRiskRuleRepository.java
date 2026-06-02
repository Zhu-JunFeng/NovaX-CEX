package com.novax.cex.risk.infrastructure.persistence.repository;

import com.novax.cex.risk.domain.model.RiskRule;
import com.novax.cex.risk.domain.repository.RiskRuleRepository;
import com.novax.cex.risk.infrastructure.persistence.dataobject.RiskRuleDO;
import com.novax.cex.risk.infrastructure.persistence.mapper.RiskRuleMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisRiskRuleRepository implements RiskRuleRepository {
    private final RiskRuleMapper mapper;

    public MybatisRiskRuleRepository(RiskRuleMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public RiskRule save(RiskRule aggregate) {
        RiskRuleDO aggregateDO = toDO(aggregate);
        if (aggregateDO.getId() == null) {
            mapper.insert(aggregateDO);
        } else {
            mapper.updateById(aggregateDO);
        }
        return toDomain(aggregateDO);
    }

    @Override
    public Optional<RiskRule> findById(String id) {
        return Optional.ofNullable(mapper.selectById(id)).map(this::toDomain);
    }

    @Override
    public List<RiskRule> findAll() {
        return mapper.selectList(null).stream().map(this::toDomain).toList();
    }

    private RiskRuleDO toDO(RiskRule aggregate) {
        RiskRuleDO aggregateDO = new RiskRuleDO();
        aggregateDO.setRuleCode(aggregate.ruleCode());
        aggregateDO.setSceneCode(aggregate.sceneCode());
        aggregateDO.setSeverity(aggregate.severity());
        aggregateDO.setEnabled(aggregate.enabled());
        return aggregateDO;
    }

    private RiskRule toDomain(RiskRuleDO record) {
        return new RiskRule(
                record.getRuleCode(),
                record.getSceneCode(),
                record.getSeverity(),
                record.isEnabled()
        );
    }
}
