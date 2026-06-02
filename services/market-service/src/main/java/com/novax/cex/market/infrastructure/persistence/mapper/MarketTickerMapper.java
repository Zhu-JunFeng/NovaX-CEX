package com.novax.cex.market.infrastructure.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.novax.cex.market.infrastructure.persistence.dataobject.MarketTickerDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MarketTickerMapper extends BaseMapper<MarketTickerDO> {
}
