package com.novax.cex.margin.infrastructure.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.novax.cex.margin.infrastructure.persistence.dataobject.MarginPositionDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MarginPositionMapper extends BaseMapper<MarginPositionDO> {
}
