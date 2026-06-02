package com.novax.cex.market.domain.model;

import java.math.BigDecimal;

/**
 * 行情快照聚合，承载最新价、标记价和行情状态。
 */
public record MarketTicker(
        String symbolCode,
        BigDecimal lastPrice,
        BigDecimal markPrice,
        String status
) {
}
