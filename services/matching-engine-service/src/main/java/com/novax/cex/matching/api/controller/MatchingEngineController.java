package com.novax.cex.matching.api.controller;

import com.novax.cex.common.api.ApiResponse;
import com.novax.cex.matching.api.dto.MatchingEngineStatusResponse;
import com.novax.cex.matching.application.MatchingEngineApplicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/matching-engine")
class MatchingEngineController {
    private final MatchingEngineApplicationService applicationService;

    MatchingEngineController(MatchingEngineApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/status")
    ApiResponse<MatchingEngineStatusResponse> status() {
        return ApiResponse.success(applicationService.status());
    }
}
