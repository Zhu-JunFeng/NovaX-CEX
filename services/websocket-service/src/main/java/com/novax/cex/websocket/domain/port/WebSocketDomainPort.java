package com.novax.cex.websocket.domain.port;

import com.novax.cex.websocket.api.dto.WebSocketStatusResponse;

public interface WebSocketDomainPort {
    WebSocketStatusResponse describe();
}
