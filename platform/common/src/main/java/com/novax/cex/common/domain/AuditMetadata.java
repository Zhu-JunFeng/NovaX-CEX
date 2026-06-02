package com.novax.cex.common.domain;

import java.time.Instant;

public record AuditMetadata(Instant createdAt, Instant updatedAt) {
}
