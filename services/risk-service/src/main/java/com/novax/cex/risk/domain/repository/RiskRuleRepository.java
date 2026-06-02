package com.novax.cex.risk.domain.repository;

import com.novax.cex.risk.domain.model.RiskRule;
import java.util.List;
import java.util.Optional;

public interface RiskRuleRepository {
    RiskRule save(RiskRule aggregate);

    Optional<RiskRule> findById(String id);

    List<RiskRule> findAll();
}
