package com.novax.cex.account.domain.model;

import java.math.BigDecimal;

public record AccountBalance(String userId, String asset, BigDecimal available, BigDecimal frozen) {
}
