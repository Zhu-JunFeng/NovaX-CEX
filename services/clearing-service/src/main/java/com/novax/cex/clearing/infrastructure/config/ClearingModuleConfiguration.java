package com.novax.cex.clearing.infrastructure.config;

import com.novax.cex.clearing.api.dto.ClearingStatusResponse;
import com.novax.cex.clearing.domain.port.ClearingDomainPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ClearingModuleConfiguration {
    @Bean
    ClearingDomainPort clearingDomainPort() {
        return () -> new ClearingStatusResponse("clearing", "settle trades and fees");
    }
}
