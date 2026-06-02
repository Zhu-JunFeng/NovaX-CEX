package com.novax.cex.admin.infrastructure.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.novax.cex.admin.infrastructure.persistence.dataobject.AdminOperatorDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminOperatorMapper extends BaseMapper<AdminOperatorDO> {
}
