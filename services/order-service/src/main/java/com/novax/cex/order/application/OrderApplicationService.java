package com.novax.cex.order.application;

import com.novax.cex.order.api.dto.CancelOrderRequest;
import com.novax.cex.order.api.dto.OrderCommandResponse;
import com.novax.cex.order.api.dto.PlaceOrderRequest;
import com.novax.cex.common.id.IdGenerator;
import com.novax.cex.order.api.dto.OrderStatusResponse;
import com.novax.cex.order.domain.model.Order;
import com.novax.cex.order.domain.model.OrderSide;
import com.novax.cex.order.domain.model.OrderStatus;
import com.novax.cex.order.domain.model.OrderType;
import com.novax.cex.order.domain.port.OrderDomainPort;
import com.novax.cex.order.domain.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderApplicationService {
    private final OrderDomainPort domainPort;
    private final OrderRepository orderRepository;

    public OrderApplicationService(OrderDomainPort domainPort, OrderRepository orderRepository) {
        this.domainPort = domainPort;
        this.orderRepository = orderRepository;
    }

    public OrderStatusResponse status() {
        return domainPort.describe();
    }

    public OrderCommandResponse place(PlaceOrderRequest request) {
        Order order = new Order(
                IdGenerator.newId(),
                request.userId(),
                request.symbol(),
                OrderSide.valueOf(request.side()),
                OrderType.valueOf(request.type()),
                OrderStatus.NEW,
                request.price(),
                request.quantity(),
                java.math.BigDecimal.ZERO
        );
        orderRepository.save(order);
        return domainPort.place(request);
    }

    public OrderCommandResponse cancel(CancelOrderRequest request) {
        return domainPort.cancel(request);
    }
}
