package com.novax.cex.futures.domain.model;

import java.math.BigDecimal;

/**
 * 合约仓位聚合，描述持仓方向、数量和合约标的。
 */
public record FuturesPosition(
        String accountId,
        String symbolCode,
        String positionSide,
        BigDecimal positionQty
) {
}
