package com.novax.cex.market.domain.model;

import java.math.BigDecimal;
import java.time.Instant;

public record Kline(
        String symbol,
        String interval,
        Instant openTime,
        BigDecimal open,
        BigDecimal high,
        BigDecimal low,
        BigDecimal close,
        BigDecimal volume
) {
}
