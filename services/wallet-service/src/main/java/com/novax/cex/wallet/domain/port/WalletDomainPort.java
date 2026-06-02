package com.novax.cex.wallet.domain.port;

import com.novax.cex.wallet.api.dto.WalletStatusResponse;

public interface WalletDomainPort {
    WalletStatusResponse describe();
}
