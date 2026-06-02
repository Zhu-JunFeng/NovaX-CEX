package com.novax.cex.order;

import com.novax.cex.order.api.dto.PlaceOrderRequest;
import jakarta.validation.Validation;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlaceOrderRequestTests {
    @Test
    void shouldRejectBlankUserId() {
        var validator = Validation.buildDefaultValidatorFactory().getValidator();
        var request = new PlaceOrderRequest("", "BTCUSDT", "BUY", "LIMIT", new BigDecimal("1"), new BigDecimal("1"));

        var violations = validator.validate(request);

        assertThat(violations).isNotEmpty();
    }
}
