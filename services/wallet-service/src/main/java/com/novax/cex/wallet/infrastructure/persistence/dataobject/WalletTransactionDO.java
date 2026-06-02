package com.novax.cex.wallet.infrastructure.persistence.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.novax.cex.persistence.model.BaseDO;
import java.math.BigDecimal;

@TableName("wallet_transactions")
public class WalletTransactionDO extends BaseDO {
    private String walletTxNo;
    private String assetCode;
    private String direction;
    private BigDecimal amount;

    public String getWalletTxNo() {
        return walletTxNo;
    }

    public void setWalletTxNo(String walletTxNo) {
        this.walletTxNo = walletTxNo;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
