package com.novax.cex.futures.domain.port;

import com.novax.cex.futures.api.dto.FuturesStatusResponse;

public interface FuturesDomainPort {
    FuturesStatusResponse describe();
}
