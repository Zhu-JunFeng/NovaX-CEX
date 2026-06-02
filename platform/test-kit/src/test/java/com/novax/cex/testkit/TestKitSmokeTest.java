package com.novax.cex.testkit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TestKitSmokeTest {
    @Test
    void shouldLoadTestKitModule() {
        assertThat("test-kit").isNotBlank();
    }
}
