package com.novax.cex.websocket.domain.model;

/**
 * 推送连接聚合，记录会话、订阅频道和连接状态。
 */
public record WebSocketSession(
        String sessionId,
        String channelCode,
        String principalId,
        String status
) {
}
