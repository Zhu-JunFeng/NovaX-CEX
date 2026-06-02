package com.novax.cex.market.infrastructure.config;

import com.novax.cex.market.api.dto.MarketStatusResponse;
import com.novax.cex.market.domain.port.MarketDomainPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MarketModuleConfiguration {
    @Bean
    MarketDomainPort marketDomainPort() {
        return () -> new MarketStatusResponse("market", "derive depth, ticker and klines");
    }
}
