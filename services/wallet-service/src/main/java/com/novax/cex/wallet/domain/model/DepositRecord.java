package com.novax.cex.wallet.domain.model;

import java.math.BigDecimal;

public record DepositRecord(String txHash, String userId, String asset, BigDecimal amount, String status) {
}
