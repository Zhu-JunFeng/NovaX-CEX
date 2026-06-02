package com.novax.cex.matching.infrastructure.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.novax.cex.matching.infrastructure.persistence.dataobject.MatchingSymbolDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MatchingSymbolMapper extends BaseMapper<MatchingSymbolDO> {
}
