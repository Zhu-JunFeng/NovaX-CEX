package com.novax.cex.futures.api.controller;

import com.novax.cex.common.api.ApiResponse;
import com.novax.cex.futures.api.dto.FuturesStatusResponse;
import com.novax.cex.futures.application.FuturesApplicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/futures")
class FuturesController {
    private final FuturesApplicationService applicationService;

    FuturesController(FuturesApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/status")
    ApiResponse<FuturesStatusResponse> status() {
        return ApiResponse.success(applicationService.status());
    }
}
