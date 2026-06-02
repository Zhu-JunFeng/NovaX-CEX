package com.novax.cex.market.api.controller;

import com.novax.cex.common.api.ApiResponse;
import com.novax.cex.market.api.dto.MarketStatusResponse;
import com.novax.cex.market.application.MarketApplicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/market")
class MarketController {
    private final MarketApplicationService applicationService;

    MarketController(MarketApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/status")
    ApiResponse<MarketStatusResponse> status() {
        return ApiResponse.success(applicationService.status());
    }
}
