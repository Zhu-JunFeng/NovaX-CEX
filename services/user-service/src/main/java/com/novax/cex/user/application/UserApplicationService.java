package com.novax.cex.user.application;

import com.novax.cex.user.api.dto.UserStatusResponse;
import com.novax.cex.user.domain.port.UserDomainPort;
import org.springframework.stereotype.Service;

@Service
public class UserApplicationService {
    private final UserDomainPort domainPort;

    public UserApplicationService(UserDomainPort domainPort) {
        this.domainPort = domainPort;
    }

    public UserStatusResponse status() {
        return domainPort.describe();
    }
}
