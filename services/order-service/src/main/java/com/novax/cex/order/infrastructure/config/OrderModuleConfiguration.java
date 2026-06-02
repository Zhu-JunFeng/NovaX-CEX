package com.novax.cex.order.infrastructure.config;

import com.novax.cex.common.id.IdGenerator;
import com.novax.cex.order.api.dto.CancelOrderRequest;
import com.novax.cex.order.api.dto.OrderCommandResponse;
import com.novax.cex.order.api.dto.PlaceOrderRequest;
import com.novax.cex.order.api.dto.OrderStatusResponse;
import com.novax.cex.order.domain.port.OrderDomainPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class OrderModuleConfiguration {
    @Bean
    OrderDomainPort orderDomainPort() {
        return new OrderDomainPort() {
            @Override
            public OrderStatusResponse describe() {
                return new OrderStatusResponse("order", "accept spot orders and cancellations");
            }

            @Override
            public OrderCommandResponse place(PlaceOrderRequest request) {
                // 当前先返回占位受理结果，后续再接真实订单持久化、风控和撮合投递。
                return new OrderCommandResponse(IdGenerator.newId(), "PLACE_ORDER", "ACCEPTED");
            }

            @Override
            public OrderCommandResponse cancel(CancelOrderRequest request) {
                // 当前先固定撤单命令返回结构，方便后续替换成真实订单撤销流程。
                return new OrderCommandResponse(request.orderId(), "CANCEL_ORDER", "ACCEPTED");
            }
        };
    }
}
