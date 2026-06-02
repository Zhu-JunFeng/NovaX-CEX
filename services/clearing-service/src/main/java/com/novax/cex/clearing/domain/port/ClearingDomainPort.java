package com.novax.cex.clearing.domain.port;

import com.novax.cex.clearing.api.dto.ClearingStatusResponse;

public interface ClearingDomainPort {
    ClearingStatusResponse describe();
}
