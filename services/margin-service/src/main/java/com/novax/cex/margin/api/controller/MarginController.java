package com.novax.cex.margin.api.controller;

import com.novax.cex.common.api.ApiResponse;
import com.novax.cex.margin.api.dto.MarginStatusResponse;
import com.novax.cex.margin.application.MarginApplicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/margin")
class MarginController {
    private final MarginApplicationService applicationService;

    MarginController(MarginApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/status")
    ApiResponse<MarginStatusResponse> status() {
        return ApiResponse.success(applicationService.status());
    }
}
