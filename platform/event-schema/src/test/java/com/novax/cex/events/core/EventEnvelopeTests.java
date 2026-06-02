package com.novax.cex.events.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.novax.cex.events.trading.OrderSubmittedEvent;
import java.math.BigDecimal;
import java.time.Instant;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EventEnvelopeTests {
    private final ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();

    @Test
    void shouldSerializeAndDeserializeEnvelope() throws Exception {
        EventEnvelope<OrderSubmittedEvent> envelope = new EventEnvelope<>(
                "evt-1",
                TopicNames.ORDER_SUBMITTED,
                1L,
                "order-1",
                "idem-1",
                Instant.parse("2026-06-02T00:00:00Z"),
                new OrderSubmittedEvent(
                        "order-1",
                        "user-1",
                        "BTCUSDT",
                        "BUY",
                        "LIMIT",
                        new BigDecimal("65000"),
                        new BigDecimal("0.5")
                )
        );

        String json = objectMapper.writeValueAsString(envelope);
        assertThat(json).contains("order.submitted");
        assertThat(json).contains("BTCUSDT");
    }
}
