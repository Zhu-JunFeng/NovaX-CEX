package com.novax.cex.events.trading;

import java.math.BigDecimal;

public record TradeExecutedEvent(
        String tradeId,
        String symbol,
        String buyOrderId,
        String sellOrderId,
        BigDecimal price,
        BigDecimal quantity,
        BigDecimal makerFee,
        BigDecimal takerFee
) {
}
