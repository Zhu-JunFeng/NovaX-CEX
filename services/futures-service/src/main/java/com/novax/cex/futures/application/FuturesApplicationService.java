package com.novax.cex.futures.application;

import com.novax.cex.futures.api.dto.FuturesStatusResponse;
import com.novax.cex.futures.domain.port.FuturesDomainPort;
import org.springframework.stereotype.Service;

@Service
public class FuturesApplicationService {
    private final FuturesDomainPort domainPort;

    public FuturesApplicationService(FuturesDomainPort domainPort) {
        this.domainPort = domainPort;
    }

    public FuturesStatusResponse status() {
        return domainPort.describe();
    }
}
