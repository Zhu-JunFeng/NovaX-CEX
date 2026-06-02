package com.novax.cex.websocket.domain.repository;

import com.novax.cex.websocket.domain.model.WebSocketSession;
import java.util.List;
import java.util.Optional;

public interface WebSocketSessionRepository {
    WebSocketSession save(WebSocketSession aggregate);

    Optional<WebSocketSession> findById(String id);

    List<WebSocketSession> findAll();
}
