package com.novax.cex.admin.api.controller;

import com.novax.cex.common.api.ApiResponse;
import com.novax.cex.admin.api.dto.AdminStatusResponse;
import com.novax.cex.admin.application.AdminApplicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
class AdminController {
    private final AdminApplicationService applicationService;

    AdminController(AdminApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/status")
    ApiResponse<AdminStatusResponse> status() {
        return ApiResponse.success(applicationService.status());
    }
}
