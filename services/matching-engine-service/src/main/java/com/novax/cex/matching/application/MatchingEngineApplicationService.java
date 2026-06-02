package com.novax.cex.matching.application;

import com.novax.cex.matching.api.dto.MatchingEngineStatusResponse;
import com.novax.cex.matching.domain.port.MatchingEngineDomainPort;
import org.springframework.stereotype.Service;

@Service
public class MatchingEngineApplicationService {
    private final MatchingEngineDomainPort domainPort;

    public MatchingEngineApplicationService(MatchingEngineDomainPort domainPort) {
        this.domainPort = domainPort;
    }

    public MatchingEngineStatusResponse status() {
        return domainPort.describe();
    }
}
