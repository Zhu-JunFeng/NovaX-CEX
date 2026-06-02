package com.novax.cex.matching.domain.model;

import java.math.BigDecimal;
import java.util.List;

public record OrderBookSnapshot(String symbol, List<PriceLevel> bids, List<PriceLevel> asks) {
    public record PriceLevel(BigDecimal price, BigDecimal quantity) {
    }
}
