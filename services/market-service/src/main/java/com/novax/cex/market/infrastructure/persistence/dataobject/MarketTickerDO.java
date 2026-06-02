package com.novax.cex.market.infrastructure.persistence.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.novax.cex.persistence.model.BaseDO;
import java.math.BigDecimal;

@TableName("market_tickers")
public class MarketTickerDO extends BaseDO {
    private String symbolCode;
    private BigDecimal lastPrice;
    private BigDecimal markPrice;
    private String status;

    public String getSymbolCode() {
        return symbolCode;
    }

    public void setSymbolCode(String symbolCode) {
        this.symbolCode = symbolCode;
    }

    public BigDecimal getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(BigDecimal lastPrice) {
        this.lastPrice = lastPrice;
    }

    public BigDecimal getMarkPrice() {
        return markPrice;
    }

    public void setMarkPrice(BigDecimal markPrice) {
        this.markPrice = markPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
