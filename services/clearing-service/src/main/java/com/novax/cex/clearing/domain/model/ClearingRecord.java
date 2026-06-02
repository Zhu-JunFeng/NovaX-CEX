package com.novax.cex.clearing.domain.model;

import java.math.BigDecimal;

/**
 * 清算记录聚合，描述成交后资金资产的清分结果。
 */
public record ClearingRecord(
        String bizId,
        String accountId,
        String assetCode,
        BigDecimal amount
) {
}
