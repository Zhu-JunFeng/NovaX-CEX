package com.novax.cex.order.infrastructure.persistence.repository;

import com.novax.cex.order.domain.model.Order;
import com.novax.cex.order.domain.repository.OrderRepository;
import com.novax.cex.order.infrastructure.persistence.dataobject.OrderDO;
import com.novax.cex.order.infrastructure.persistence.mapper.OrderMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisOrderRepository implements OrderRepository {
    private final OrderMapper orderMapper;

    public MybatisOrderRepository(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public void save(Order order) {
        // 领域对象在这里转换成持久化对象，避免数据库细节污染领域层。
        OrderDO dataObject = new OrderDO();
        dataObject.setId(order.orderId());
        dataObject.setUserId(order.userId());
        dataObject.setSymbol(order.symbol());
        dataObject.setSide(order.side().name());
        dataObject.setType(order.type().name());
        dataObject.setStatus(order.status().name());
        dataObject.setPrice(order.price());
        dataObject.setQuantity(order.quantity());
        dataObject.setExecutedQuantity(order.executedQuantity());
        orderMapper.insert(dataObject);
    }
}
