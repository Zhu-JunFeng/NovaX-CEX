package com.novax.cex.futures.infrastructure.config;

import com.novax.cex.futures.api.dto.FuturesStatusResponse;
import com.novax.cex.futures.domain.port.FuturesDomainPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class FuturesModuleConfiguration {
    @Bean
    FuturesDomainPort futuresDomainPort() {
        return () -> new FuturesStatusResponse("futures", "manage perpetual positions and pnl");
    }
}
