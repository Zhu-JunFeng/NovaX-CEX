package com.novax.cex.gateway.infrastructure.config;

import com.novax.cex.gateway.api.dto.GatewayStatusResponse;
import com.novax.cex.gateway.domain.port.GatewayDomainPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class GatewayModuleConfiguration {
    @Bean
    GatewayDomainPort gatewayDomainPort() {
        return () -> new GatewayStatusResponse("gateway", "route platform traffic and entry policies");
    }
}
