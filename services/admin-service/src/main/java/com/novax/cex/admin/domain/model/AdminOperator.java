package com.novax.cex.admin.domain.model;

/**
 * 管理后台操作员聚合，记录后台用户及角色权限分配。
 */
public record AdminOperator(
        String operatorNo,
        String displayName,
        String roleCode,
        String status
) {
}
