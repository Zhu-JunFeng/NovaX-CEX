package com.novax.cex.clearing.api.controller;

import com.novax.cex.common.api.ApiResponse;
import com.novax.cex.clearing.api.dto.ClearingStatusResponse;
import com.novax.cex.clearing.application.ClearingApplicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/clearing")
class ClearingController {
    private final ClearingApplicationService applicationService;

    ClearingController(ClearingApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/status")
    ApiResponse<ClearingStatusResponse> status() {
        return ApiResponse.success(applicationService.status());
    }
}
