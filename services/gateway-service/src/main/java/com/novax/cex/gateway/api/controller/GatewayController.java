package com.novax.cex.gateway.api.controller;

import com.novax.cex.common.api.ApiResponse;
import com.novax.cex.gateway.api.dto.GatewayStatusResponse;
import com.novax.cex.gateway.application.GatewayApplicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/gateway")
class GatewayController {
    private final GatewayApplicationService applicationService;

    GatewayController(GatewayApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/status")
    ApiResponse<GatewayStatusResponse> status() {
        return ApiResponse.success(applicationService.status());
    }
}
