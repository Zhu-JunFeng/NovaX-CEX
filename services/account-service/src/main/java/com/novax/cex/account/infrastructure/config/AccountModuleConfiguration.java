package com.novax.cex.account.infrastructure.config;

import com.novax.cex.account.api.dto.AccountStatusResponse;
import com.novax.cex.account.domain.port.AccountDomainPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AccountModuleConfiguration {
    @Bean
    AccountDomainPort accountDomainPort() {
        return () -> new AccountStatusResponse("account", "manage balances, journals and freezes");
    }
}
