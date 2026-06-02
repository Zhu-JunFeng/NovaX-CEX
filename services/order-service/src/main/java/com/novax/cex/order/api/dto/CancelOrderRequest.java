package com.novax.cex.order.api.dto;

import jakarta.validation.constraints.NotBlank;

public record CancelOrderRequest(@NotBlank String orderId, @NotBlank String userId) {
}
