package com.novax.cex.clearing.application;

import com.novax.cex.clearing.api.dto.ClearingStatusResponse;
import com.novax.cex.clearing.domain.port.ClearingDomainPort;
import org.springframework.stereotype.Service;

@Service
public class ClearingApplicationService {
    private final ClearingDomainPort domainPort;

    public ClearingApplicationService(ClearingDomainPort domainPort) {
        this.domainPort = domainPort;
    }

    public ClearingStatusResponse status() {
        return domainPort.describe();
    }
}
