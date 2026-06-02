package com.novax.cex.events.market;

import java.math.BigDecimal;
import java.util.List;

public record DepthUpdatedEvent(
        String symbol,
        long lastUpdateId,
        List<PriceLevel> bids,
        List<PriceLevel> asks
) {
    public record PriceLevel(BigDecimal price, BigDecimal quantity) {
    }
}
