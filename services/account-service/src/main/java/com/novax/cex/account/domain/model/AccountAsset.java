package com.novax.cex.account.domain.model;

import java.math.BigDecimal;

/**
 * 账户资产聚合，记录币种余额、冻结金额等账本快照。
 */
public record AccountAsset(
        String accountId,
        String assetCode,
        BigDecimal availableBalance,
        BigDecimal frozenBalance
) {
}
