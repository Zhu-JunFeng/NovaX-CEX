package com.novax.cex.wallet.api.controller;

import com.novax.cex.common.api.ApiResponse;
import com.novax.cex.wallet.api.dto.WalletStatusResponse;
import com.novax.cex.wallet.application.WalletApplicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/wallet")
class WalletController {
    private final WalletApplicationService applicationService;

    WalletController(WalletApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/status")
    ApiResponse<WalletStatusResponse> status() {
        return ApiResponse.success(applicationService.status());
    }
}
