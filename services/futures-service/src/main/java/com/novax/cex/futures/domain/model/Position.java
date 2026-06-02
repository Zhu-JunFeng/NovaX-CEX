package com.novax.cex.futures.domain.model;

import java.math.BigDecimal;

public record Position(
        String userId,
        String symbol,
        String side,
        BigDecimal positionSize,
        BigDecimal entryPrice,
        BigDecimal markPrice,
        BigDecimal leverage,
        BigDecimal margin,
        BigDecimal unrealizedPnl,
        BigDecimal liquidationPrice
) {
}
