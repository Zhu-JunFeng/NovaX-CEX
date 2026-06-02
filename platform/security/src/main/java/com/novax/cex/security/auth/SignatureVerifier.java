package com.novax.cex.security.auth;

public interface SignatureVerifier {
    boolean verify(String payload, String signature, String secret);
}
