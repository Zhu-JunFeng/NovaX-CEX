package com.novax.cex.margin.domain.port;

import com.novax.cex.margin.api.dto.MarginStatusResponse;

public interface MarginDomainPort {
    MarginStatusResponse describe();
}
