package com.novax.cex.gateway.domain.model;

/**
 * 网关路由聚合，描述入口路由和下游服务映射。
 */
public record GatewayRoute(
        String routeKey,
        String targetService,
        String uriPattern,
        Boolean enabled
) {
}
