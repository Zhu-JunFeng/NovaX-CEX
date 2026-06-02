package com.novax.cex.wallet.application;

import com.novax.cex.wallet.api.dto.WalletStatusResponse;
import com.novax.cex.wallet.domain.port.WalletDomainPort;
import org.springframework.stereotype.Service;

@Service
public class WalletApplicationService {
    private final WalletDomainPort domainPort;

    public WalletApplicationService(WalletDomainPort domainPort) {
        this.domainPort = domainPort;
    }

    public WalletStatusResponse status() {
        return domainPort.describe();
    }
}
