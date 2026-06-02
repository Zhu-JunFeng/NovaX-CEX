package com.novax.cex.risk.infrastructure.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.novax.cex.risk.infrastructure.persistence.dataobject.RiskRuleDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RiskRuleMapper extends BaseMapper<RiskRuleDO> {
}
