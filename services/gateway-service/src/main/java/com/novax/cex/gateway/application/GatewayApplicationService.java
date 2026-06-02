package com.novax.cex.gateway.application;

import com.novax.cex.gateway.api.dto.GatewayStatusResponse;
import com.novax.cex.gateway.domain.port.GatewayDomainPort;
import org.springframework.stereotype.Service;

@Service
public class GatewayApplicationService {
    private final GatewayDomainPort domainPort;

    public GatewayApplicationService(GatewayDomainPort domainPort) {
        this.domainPort = domainPort;
    }

    public GatewayStatusResponse status() {
        return domainPort.describe();
    }
}
