package com.novax.cex.wallet.domain.model;

import java.math.BigDecimal;

public record WithdrawRequest(String withdrawId, String userId, String asset, BigDecimal amount, String address) {
}
