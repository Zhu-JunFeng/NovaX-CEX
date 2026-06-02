package com.novax.cex.risk.infrastructure.config;

import com.novax.cex.risk.api.dto.RiskStatusResponse;
import com.novax.cex.risk.domain.port.RiskDomainPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class RiskModuleConfiguration {
    @Bean
    RiskDomainPort riskDomainPort() {
        return () -> new RiskStatusResponse("risk", "run pre-trade and runtime risk checks");
    }
}
