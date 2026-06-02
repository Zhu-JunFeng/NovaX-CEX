package com.novax.cex.futures.infrastructure.persistence.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.novax.cex.persistence.model.BaseDO;
import java.math.BigDecimal;

@TableName("futures_positions")
public class FuturesPositionDO extends BaseDO {
    private String accountId;
    private String symbolCode;
    private String positionSide;
    private BigDecimal positionQty;

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

    public String getPositionSide() {
        return positionSide;
    }

    public void setPositionSide(String positionSide) {
        this.positionSide = positionSide;
    }

    public BigDecimal getPositionQty() {
        return positionQty;
    }

    public void setPositionQty(BigDecimal positionQty) {
        this.positionQty = positionQty;
    }
}
