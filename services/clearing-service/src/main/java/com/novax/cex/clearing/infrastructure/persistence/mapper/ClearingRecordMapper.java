package com.novax.cex.clearing.infrastructure.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.novax.cex.clearing.infrastructure.persistence.dataobject.ClearingRecordDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClearingRecordMapper extends BaseMapper<ClearingRecordDO> {
}
