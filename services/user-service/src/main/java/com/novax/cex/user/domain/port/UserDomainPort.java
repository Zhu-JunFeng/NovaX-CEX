package com.novax.cex.user.domain.port;

import com.novax.cex.user.api.dto.UserStatusResponse;

public interface UserDomainPort {
    UserStatusResponse describe();
}
