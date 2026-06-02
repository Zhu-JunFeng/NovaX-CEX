package com.novax.cex.account.api.controller;

import com.novax.cex.common.api.ApiResponse;
import com.novax.cex.account.api.dto.AccountStatusResponse;
import com.novax.cex.account.application.AccountApplicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/account")
class AccountController {
    private final AccountApplicationService applicationService;

    AccountController(AccountApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/status")
    ApiResponse<AccountStatusResponse> status() {
        return ApiResponse.success(applicationService.status());
    }
}
