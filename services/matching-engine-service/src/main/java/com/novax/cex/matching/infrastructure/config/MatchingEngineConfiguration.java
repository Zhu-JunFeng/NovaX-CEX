package com.novax.cex.matching.infrastructure.config;

import com.novax.cex.events.trading.OrderSubmittedEvent;
import com.novax.cex.matching.api.dto.MatchingEngineStatusResponse;
import com.novax.cex.matching.domain.model.OrderBookSnapshot;
import com.novax.cex.matching.domain.port.MatchingEngineDomainPort;
import com.novax.cex.matching.domain.port.MatchingEnginePort;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MatchingEngineConfiguration {
    @Bean
    MatchingEngineDomainPort matchingDomainPort() {
        return () -> new MatchingEngineStatusResponse("matching-engine", "maintain in-memory books and emit trades");
    }

    @Bean
    MatchingEnginePort matchingEnginePort() {
        return new MatchingEnginePort() {
            @Override
            public List<String> accept(OrderSubmittedEvent event) {
                // 这里先用极简占位实现固化接口形状，后续替换成真实订单簿撮合逻辑。
                return List.of("accepted:" + event.orderId());
            }

            @Override
            public OrderBookSnapshot snapshot(String symbol) {
                // 先返回空盘口快照，后续由内存订单簿填充真实买卖盘数据。
                return new OrderBookSnapshot(symbol, List.of(), List.of());
            }
        };
    }
}
