package com.novax.cex.market.domain.port;

import com.novax.cex.market.api.dto.MarketStatusResponse;

public interface MarketDomainPort {
    MarketStatusResponse describe();
}
