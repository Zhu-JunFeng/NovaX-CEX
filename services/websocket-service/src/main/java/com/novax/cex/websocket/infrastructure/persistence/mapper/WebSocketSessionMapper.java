package com.novax.cex.websocket.infrastructure.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.novax.cex.websocket.infrastructure.persistence.dataobject.WebSocketSessionDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WebSocketSessionMapper extends BaseMapper<WebSocketSessionDO> {
}
