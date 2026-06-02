package com.novax.cex.account.infrastructure.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.novax.cex.account.infrastructure.persistence.dataobject.AccountAssetDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountAssetMapper extends BaseMapper<AccountAssetDO> {
}
