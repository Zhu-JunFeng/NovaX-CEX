package com.novax.cex.websocket.infrastructure.config;

import com.novax.cex.websocket.api.dto.WebSocketStatusResponse;
import com.novax.cex.websocket.domain.port.WebSocketDomainPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class WebSocketModuleConfiguration {
    @Bean
    WebSocketDomainPort websocketDomainPort() {
        return () -> new WebSocketStatusResponse("websocket", "push user and market streams");
    }
}
