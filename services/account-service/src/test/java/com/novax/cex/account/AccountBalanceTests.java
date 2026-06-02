package com.novax.cex.account;

import com.novax.cex.account.domain.model.AccountBalance;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccountBalanceTests {
    @Test
    void shouldExposeAvailableAndFrozenBalance() {
        var balance = new AccountBalance("user-1", "USDT", new BigDecimal("100"), new BigDecimal("20"));

        assertThat(balance.available()).isEqualByComparingTo("100");
        assertThat(balance.frozen()).isEqualByComparingTo("20");
    }
}
