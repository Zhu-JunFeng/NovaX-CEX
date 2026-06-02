package com.novax.cex.account.application;

import com.novax.cex.account.api.dto.AccountStatusResponse;
import com.novax.cex.account.domain.port.AccountDomainPort;
import org.springframework.stereotype.Service;

@Service
public class AccountApplicationService {
    private final AccountDomainPort domainPort;

    public AccountApplicationService(AccountDomainPort domainPort) {
        this.domainPort = domainPort;
    }

    public AccountStatusResponse status() {
        return domainPort.describe();
    }
}
