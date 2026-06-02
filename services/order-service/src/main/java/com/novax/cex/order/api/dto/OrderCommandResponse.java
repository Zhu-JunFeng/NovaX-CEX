package com.novax.cex.order.api.dto;

public record OrderCommandResponse(String orderId, String action, String status) {
}
