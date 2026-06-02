package com.novax.cex.order.domain.model;

import java.math.BigDecimal;

public record Order(
        // 订单聚合根承载撮合前的核心业务状态，避免领域层直接依赖数据库模型。
        String orderId,
        String userId,
        String symbol,
        OrderSide side,
        OrderType type,
        OrderStatus status,
        BigDecimal price,
        BigDecimal quantity,
        BigDecimal executedQuantity
) {
}
