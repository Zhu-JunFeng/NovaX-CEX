package com.novax.cex.account.domain.model;

import java.math.BigDecimal;
import java.time.Instant;

public record BalanceJournal(
        String journalId,
        String userId,
        String asset,
        BigDecimal changeAmount,
        String changeType,
        String refType,
        String refId,
        BigDecimal beforeBalance,
        BigDecimal afterBalance,
        Instant createdAt
) {
    // 账务流水是后续做对账、审计、余额重放的基础对象，任何余额变化都应可追溯到这里。
}
