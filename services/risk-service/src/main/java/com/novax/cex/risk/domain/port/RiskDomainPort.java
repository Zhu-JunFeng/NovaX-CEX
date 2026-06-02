package com.novax.cex.risk.domain.port;

import com.novax.cex.risk.api.dto.RiskStatusResponse;

public interface RiskDomainPort {
    RiskStatusResponse describe();
}
