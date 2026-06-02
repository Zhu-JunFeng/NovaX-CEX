package com.novax.cex.risk.domain.model;

/**
 * 风控规则聚合，描述风控场景、等级和启停状态。
 */
public record RiskRule(
        String ruleCode,
        String sceneCode,
        String severity,
        Boolean enabled
) {
}
