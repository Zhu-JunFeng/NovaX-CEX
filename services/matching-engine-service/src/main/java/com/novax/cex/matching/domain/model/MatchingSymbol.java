package com.novax.cex.matching.domain.model;

/**
 * 撮合标的聚合，描述交易对配置和撮合可用状态。
 */
public record MatchingSymbol(
        String symbolCode,
        String baseAsset,
        String quoteAsset,
        String status
) {
}
