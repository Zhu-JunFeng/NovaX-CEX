package com.novax.cex.matching.domain.port;

import com.novax.cex.events.trading.OrderSubmittedEvent;
import com.novax.cex.matching.domain.model.OrderBookSnapshot;
import java.util.List;

public interface MatchingEnginePort {
    // 接收订单事件并返回撮合过程产生的结果标识，后续可替换为成交事件列表或事件批次。
    List<String> accept(OrderSubmittedEvent event);

    // 对外提供订单簿快照接口，方便行情服务或调试接口读取当前盘口状态。
    OrderBookSnapshot snapshot(String symbol);
}
