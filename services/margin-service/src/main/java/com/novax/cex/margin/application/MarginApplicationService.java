package com.novax.cex.margin.application;

import com.novax.cex.margin.api.dto.MarginStatusResponse;
import com.novax.cex.margin.domain.port.MarginDomainPort;
import org.springframework.stereotype.Service;

@Service
public class MarginApplicationService {
    private final MarginDomainPort domainPort;

    public MarginApplicationService(MarginDomainPort domainPort) {
        this.domainPort = domainPort;
    }

    public MarginStatusResponse status() {
        return domainPort.describe();
    }
}
