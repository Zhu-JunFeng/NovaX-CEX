package com.novax.cex.gateway.infrastructure.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.novax.cex.gateway.infrastructure.persistence.dataobject.GatewayRouteDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GatewayRouteMapper extends BaseMapper<GatewayRouteDO> {
}
