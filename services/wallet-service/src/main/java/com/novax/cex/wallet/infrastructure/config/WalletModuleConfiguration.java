package com.novax.cex.wallet.infrastructure.config;

import com.novax.cex.wallet.api.dto.WalletStatusResponse;
import com.novax.cex.wallet.domain.port.WalletDomainPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class WalletModuleConfiguration {
    @Bean
    WalletDomainPort walletDomainPort() {
        return () -> new WalletStatusResponse("wallet", "handle deposits and withdrawals");
    }
}
