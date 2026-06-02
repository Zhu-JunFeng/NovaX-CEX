package com.novax.cex.common.time;

import java.time.Clock;
import java.time.Instant;

public final class SystemClock {
    private static final Clock CLOCK = Clock.systemUTC();

    private SystemClock() {
    }

    public static Instant now() {
        return Instant.now(CLOCK);
    }
}
