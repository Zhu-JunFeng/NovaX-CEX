package com.novax.cex.market.application;

import com.novax.cex.market.api.dto.MarketStatusResponse;
import com.novax.cex.market.domain.port.MarketDomainPort;
import org.springframework.stereotype.Service;

@Service
public class MarketApplicationService {
    private final MarketDomainPort domainPort;

    public MarketApplicationService(MarketDomainPort domainPort) {
        this.domainPort = domainPort;
    }

    public MarketStatusResponse status() {
        return domainPort.describe();
    }
}
