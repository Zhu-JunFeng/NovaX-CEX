package com.novax.cex.user.infrastructure.persistence.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.novax.cex.persistence.model.BaseDO;

@TableName("user_profiles")
public class UserProfileDO extends BaseDO {
    private String userNo;
    private String displayName;
    private String kycLevel;
    private String status;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getKycLevel() {
        return kycLevel;
    }

    public void setKycLevel(String kycLevel) {
        this.kycLevel = kycLevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
