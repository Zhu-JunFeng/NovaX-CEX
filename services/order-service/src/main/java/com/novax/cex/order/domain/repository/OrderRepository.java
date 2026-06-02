package com.novax.cex.order.domain.repository;

import com.novax.cex.order.domain.model.Order;

public interface OrderRepository {
    void save(Order order);
}
