package com.novax.cex.common.api;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record PageRequest(
        @Min(0) int page,
        @Min(1) @Max(200) int size
) {
    public static PageRequest firstPage() {
        return new PageRequest(0, 20);
    }
}
