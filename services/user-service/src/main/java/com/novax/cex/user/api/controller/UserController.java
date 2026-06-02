package com.novax.cex.user.api.controller;

import com.novax.cex.common.api.ApiResponse;
import com.novax.cex.user.api.dto.UserStatusResponse;
import com.novax.cex.user.application.UserApplicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
class UserController {
    private final UserApplicationService applicationService;

    UserController(UserApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/status")
    ApiResponse<UserStatusResponse> status() {
        return ApiResponse.success(applicationService.status());
    }
}
