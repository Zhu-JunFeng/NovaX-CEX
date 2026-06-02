package com.novax.cex.websocket.application;

import com.novax.cex.websocket.api.dto.WebSocketStatusResponse;
import com.novax.cex.websocket.domain.port.WebSocketDomainPort;
import org.springframework.stereotype.Service;

@Service
public class WebSocketApplicationService {
    private final WebSocketDomainPort domainPort;

    public WebSocketApplicationService(WebSocketDomainPort domainPort) {
        this.domainPort = domainPort;
    }

    public WebSocketStatusResponse status() {
        return domainPort.describe();
    }
}
