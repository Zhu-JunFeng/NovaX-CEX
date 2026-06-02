package com.novax.cex.account.domain.port;

import com.novax.cex.account.api.dto.AccountStatusResponse;

public interface AccountDomainPort {
    AccountStatusResponse describe();
}
