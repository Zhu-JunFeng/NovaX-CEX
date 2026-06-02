package com.novax.cex.risk.application;

import com.novax.cex.risk.api.dto.RiskStatusResponse;
import com.novax.cex.risk.domain.port.RiskDomainPort;
import org.springframework.stereotype.Service;

@Service
public class RiskApplicationService {
    private final RiskDomainPort domainPort;

    public RiskApplicationService(RiskDomainPort domainPort) {
        this.domainPort = domainPort;
    }

    public RiskStatusResponse status() {
        return domainPort.describe();
    }
}
