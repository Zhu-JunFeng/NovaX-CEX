package com.novax.cex.clearing.infrastructure.persistence.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.novax.cex.persistence.model.BaseDO;
import java.math.BigDecimal;

@TableName("clearing_records")
public class ClearingRecordDO extends BaseDO {
    private String bizId;
    private String accountId;
    private String assetCode;
    private BigDecimal amount;

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
