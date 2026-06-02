package com.novax.cex.matching.domain.port;

import com.novax.cex.matching.api.dto.MatchingEngineStatusResponse;

public interface MatchingEngineDomainPort {
    MatchingEngineStatusResponse describe();
}
