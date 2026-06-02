package com.novax.cex.futures.infrastructure.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.novax.cex.futures.infrastructure.persistence.dataobject.FuturesPositionDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FuturesPositionMapper extends BaseMapper<FuturesPositionDO> {
}
