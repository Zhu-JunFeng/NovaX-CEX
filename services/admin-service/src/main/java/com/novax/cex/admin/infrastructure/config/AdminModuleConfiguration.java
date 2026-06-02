package com.novax.cex.admin.infrastructure.config;

import com.novax.cex.admin.api.dto.AdminStatusResponse;
import com.novax.cex.admin.domain.port.AdminDomainPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AdminModuleConfiguration {
    @Bean
    AdminDomainPort adminDomainPort() {
        return () -> new AdminStatusResponse("admin", "manage exchange configuration and operations");
    }
}
