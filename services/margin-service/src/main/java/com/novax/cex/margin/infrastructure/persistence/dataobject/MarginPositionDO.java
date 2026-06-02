package com.novax.cex.margin.infrastructure.persistence.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.novax.cex.persistence.model.BaseDO;
import java.math.BigDecimal;

@TableName("margin_positions")
public class MarginPositionDO extends BaseDO {
    private String accountId;
    private String symbolCode;
    private BigDecimal borrowedAmount;
    private String healthStatus;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getSymbolCode() {
        return symbolCode;
    }

    public void setSymbolCode(String symbolCode) {
        this.symbolCode = symbolCode;
    }

    public BigDecimal getBorrowedAmount() {
        return borrowedAmount;
    }

    public void setBorrowedAmount(BigDecimal borrowedAmount) {
        this.borrowedAmount = borrowedAmount;
    }

    public String getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(String healthStatus) {
        this.healthStatus = healthStatus;
    }
}
