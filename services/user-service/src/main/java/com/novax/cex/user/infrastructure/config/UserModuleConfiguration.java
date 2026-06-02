package com.novax.cex.user.infrastructure.config;

import com.novax.cex.user.api.dto.UserStatusResponse;
import com.novax.cex.user.domain.port.UserDomainPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class UserModuleConfiguration {
    @Bean
    UserDomainPort userDomainPort() {
        return () -> new UserStatusResponse("user", "manage users, kyc and sub-accounts");
    }
}
