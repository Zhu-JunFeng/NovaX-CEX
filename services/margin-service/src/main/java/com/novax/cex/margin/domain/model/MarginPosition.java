package com.novax.cex.margin.domain.model;

import java.math.BigDecimal;

/**
 * 杠杆仓位聚合，描述借贷余额与健康度状态。
 */
public record MarginPosition(
        String accountId,
        String symbolCode,
        BigDecimal borrowedAmount,
        String healthStatus
) {
}
