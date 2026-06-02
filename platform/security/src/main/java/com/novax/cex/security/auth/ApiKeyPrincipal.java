package com.novax.cex.security.auth;

import java.util.Set;

public record ApiKeyPrincipal(String keyId, String accountId, Set<String> permissions) {
}
