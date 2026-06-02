package com.novax.cex.wallet.domain.model;

import java.math.BigDecimal;

/**
 * 钱包流水聚合，覆盖充值、提现和链上划转业务。
 */
public record WalletTransaction(
        String walletTxNo,
        String assetCode,
        String direction,
        BigDecimal amount
) {
}
