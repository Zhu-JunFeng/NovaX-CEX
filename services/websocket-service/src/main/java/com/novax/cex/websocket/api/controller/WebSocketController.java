package com.novax.cex.websocket.api.controller;

import com.novax.cex.common.api.ApiResponse;
import com.novax.cex.websocket.api.dto.WebSocketStatusResponse;
import com.novax.cex.websocket.application.WebSocketApplicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/websocket")
class WebSocketController {
    private final WebSocketApplicationService applicationService;

    WebSocketController(WebSocketApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/status")
    ApiResponse<WebSocketStatusResponse> status() {
        return ApiResponse.success(applicationService.status());
    }
}
