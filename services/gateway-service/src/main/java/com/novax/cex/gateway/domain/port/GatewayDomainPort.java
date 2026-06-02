package com.novax.cex.gateway.domain.port;

import com.novax.cex.gateway.api.dto.GatewayStatusResponse;

public interface GatewayDomainPort {
    GatewayStatusResponse describe();
}
