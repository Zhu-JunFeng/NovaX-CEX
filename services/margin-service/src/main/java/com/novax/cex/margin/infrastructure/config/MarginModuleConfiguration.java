package com.novax.cex.margin.infrastructure.config;

import com.novax.cex.margin.api.dto.MarginStatusResponse;
import com.novax.cex.margin.domain.port.MarginDomainPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MarginModuleConfiguration {
    @Bean
    MarginDomainPort marginDomainPort() {
        return () -> new MarginStatusResponse("margin", "manage borrowing, interest and leverage");
    }
}
