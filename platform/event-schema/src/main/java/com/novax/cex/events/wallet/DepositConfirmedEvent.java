package com.novax.cex.events.wallet;

import java.math.BigDecimal;

public record DepositConfirmedEvent(String txHash, String userId, String asset, BigDecimal amount) {
}
