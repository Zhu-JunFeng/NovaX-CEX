package com.novax.cex.order.domain.port;

import com.novax.cex.order.api.dto.CancelOrderRequest;
import com.novax.cex.order.api.dto.OrderCommandResponse;
import com.novax.cex.order.api.dto.PlaceOrderRequest;
import com.novax.cex.order.api.dto.OrderStatusResponse;

public interface OrderDomainPort {
    OrderStatusResponse describe();

    OrderCommandResponse place(PlaceOrderRequest request);

    OrderCommandResponse cancel(CancelOrderRequest request);
}
