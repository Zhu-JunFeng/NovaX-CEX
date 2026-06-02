package com.novax.cex.risk.domain.model;

import java.util.Map;

public record RiskCheckRequest(String checkType, String accountId, Map<String, String> attributes) {
}
