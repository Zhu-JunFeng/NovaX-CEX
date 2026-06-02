package com.novax.cex.events.trading;

import java.math.BigDecimal;

public record OrderSubmittedEvent(
        String orderId,
        String userId,
        String symbol,
        String side,
        String type,
        BigDecimal price,
        BigDecimal quantity
) {
}
