package com.novax.cex.user.domain.model;

/**
 * 用户档案聚合，承载账户主档、KYC 等级和状态信息。
 */
public record UserProfile(
        String userNo,
        String displayName,
        String kycLevel,
        String status
) {
}
