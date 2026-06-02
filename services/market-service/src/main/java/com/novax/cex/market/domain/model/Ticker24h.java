package com.novax.cex.market.domain.model;

import java.math.BigDecimal;

public record Ticker24h(String symbol, BigDecimal lastPrice, BigDecimal volume) {
}
