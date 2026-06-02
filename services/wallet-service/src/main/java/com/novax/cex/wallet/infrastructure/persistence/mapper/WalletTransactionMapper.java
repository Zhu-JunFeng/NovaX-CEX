package com.novax.cex.wallet.infrastructure.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.novax.cex.wallet.infrastructure.persistence.dataobject.WalletTransactionDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WalletTransactionMapper extends BaseMapper<WalletTransactionDO> {
}
