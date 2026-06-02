package com.novax.cex.risk.domain.model;

public record RiskCheckResult(boolean allowed, String reasonCode, String message) {
}
