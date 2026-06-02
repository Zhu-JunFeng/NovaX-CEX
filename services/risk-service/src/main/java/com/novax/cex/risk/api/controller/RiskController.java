package com.novax.cex.risk.api.controller;

import com.novax.cex.common.api.ApiResponse;
import com.novax.cex.risk.api.dto.RiskStatusResponse;
import com.novax.cex.risk.application.RiskApplicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/risk")
class RiskController {
    private final RiskApplicationService applicationService;

    RiskController(RiskApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/status")
    ApiResponse<RiskStatusResponse> status() {
        return ApiResponse.success(applicationService.status());
    }
}
