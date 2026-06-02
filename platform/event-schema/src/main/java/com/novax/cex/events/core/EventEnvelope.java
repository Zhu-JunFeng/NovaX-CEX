package com.novax.cex.events.core;

import java.time.Instant;

public record EventEnvelope<T>(
        String eventId,
        String eventType,
        long sequence,
        String aggregateId,
        String idempotencyKey,
        Instant occurredAt,
        T payload
) {
    // 所有跨服务事件统一包一层信封，后续便于顺序消费、幂等处理和事件重放。
}
