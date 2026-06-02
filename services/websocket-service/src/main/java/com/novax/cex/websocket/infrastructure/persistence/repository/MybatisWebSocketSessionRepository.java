package com.novax.cex.websocket.infrastructure.persistence.repository;

import com.novax.cex.websocket.domain.model.WebSocketSession;
import com.novax.cex.websocket.domain.repository.WebSocketSessionRepository;
import com.novax.cex.websocket.infrastructure.persistence.dataobject.WebSocketSessionDO;
import com.novax.cex.websocket.infrastructure.persistence.mapper.WebSocketSessionMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisWebSocketSessionRepository implements WebSocketSessionRepository {
    private final WebSocketSessionMapper mapper;

    public MybatisWebSocketSessionRepository(WebSocketSessionMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public WebSocketSession save(WebSocketSession aggregate) {
        WebSocketSessionDO aggregateDO = toDO(aggregate);
        if (aggregateDO.getId() == null) {
            mapper.insert(aggregateDO);
        } else {
            mapper.updateById(aggregateDO);
        }
        return toDomain(aggregateDO);
    }

    @Override
    public Optional<WebSocketSession> findById(String id) {
        return Optional.ofNullable(mapper.selectById(id)).map(this::toDomain);
    }

    @Override
    public List<WebSocketSession> findAll() {
        return mapper.selectList(null).stream().map(this::toDomain).toList();
    }

    private WebSocketSessionDO toDO(WebSocketSession aggregate) {
        WebSocketSessionDO aggregateDO = new WebSocketSessionDO();
        aggregateDO.setSessionId(aggregate.sessionId());
        aggregateDO.setChannelCode(aggregate.channelCode());
        aggregateDO.setPrincipalId(aggregate.principalId());
        aggregateDO.setStatus(aggregate.status());
        return aggregateDO;
    }

    private WebSocketSession toDomain(WebSocketSessionDO record) {
        return new WebSocketSession(
                record.getSessionId(),
                record.getChannelCode(),
                record.getPrincipalId(),
                record.getStatus()
        );
    }
}
