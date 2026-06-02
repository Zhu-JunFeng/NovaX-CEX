package com.novax.cex.order.api.controller;

import com.novax.cex.common.api.ApiResponse;
import com.novax.cex.order.api.dto.CancelOrderRequest;
import com.novax.cex.order.api.dto.OrderCommandResponse;
import com.novax.cex.order.api.dto.OrderStatusResponse;
import com.novax.cex.order.api.dto.PlaceOrderRequest;
import jakarta.validation.Valid;
import com.novax.cex.order.application.OrderApplicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
class OrderController {
    private final OrderApplicationService applicationService;

    OrderController(OrderApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/status")
    ApiResponse<OrderStatusResponse> status() {
        return ApiResponse.success(applicationService.status());
    }

    @PostMapping
    ApiResponse<OrderCommandResponse> place(@Valid @RequestBody PlaceOrderRequest request) {
        // 当前阶段先把下单入口和命令边界固定下来，后续再接风控、冻结和撮合链路。
        return ApiResponse.success(applicationService.place(request));
    }

    @PostMapping("/cancel")
    ApiResponse<OrderCommandResponse> cancel(@Valid @RequestBody CancelOrderRequest request) {
        // 撤单入口单独保留，后续可以在这里挂订单状态校验与撤单权限校验。
        return ApiResponse.success(applicationService.cancel(request));
    }
}
