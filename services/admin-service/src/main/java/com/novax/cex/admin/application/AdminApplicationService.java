package com.novax.cex.admin.application;

import com.novax.cex.admin.api.dto.AdminStatusResponse;
import com.novax.cex.admin.domain.port.AdminDomainPort;
import org.springframework.stereotype.Service;

@Service
public class AdminApplicationService {
    private final AdminDomainPort domainPort;

    public AdminApplicationService(AdminDomainPort domainPort) {
        this.domainPort = domainPort;
    }

    public AdminStatusResponse status() {
        return domainPort.describe();
    }
}
