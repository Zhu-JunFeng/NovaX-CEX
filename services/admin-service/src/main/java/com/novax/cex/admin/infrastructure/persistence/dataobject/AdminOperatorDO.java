package com.novax.cex.admin.infrastructure.persistence.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.novax.cex.persistence.model.BaseDO;

@TableName("admin_operators")
public class AdminOperatorDO extends BaseDO {
    private String operatorNo;
    private String displayName;
    private String roleCode;
    private String status;

    public String getOperatorNo() {
        return operatorNo;
    }

    public void setOperatorNo(String operatorNo) {
        this.operatorNo = operatorNo;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
