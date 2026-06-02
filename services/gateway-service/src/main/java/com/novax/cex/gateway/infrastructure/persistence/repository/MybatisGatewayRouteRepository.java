package com.novax.cex.gateway.infrastructure.persistence.repository;

import com.novax.cex.gateway.domain.model.GatewayRoute;
import com.novax.cex.gateway.domain.repository.GatewayRouteRepository;
import com.novax.cex.gateway.infrastructure.persistence.dataobject.GatewayRouteDO;
import com.novax.cex.gateway.infrastructure.persistence.mapper.GatewayRouteMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisGatewayRouteRepository implements GatewayRouteRepository {
    private final GatewayRouteMapper mapper;

    public MybatisGatewayRouteRepository(GatewayRouteMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public GatewayRoute save(GatewayRoute aggregate) {
        GatewayRouteDO aggregateDO = toDO(aggregate);
        if (aggregateDO.getId() == null) {
            mapper.insert(aggregateDO);
        } else {
            mapper.updateById(aggregateDO);
        }
        return toDomain(aggregateDO);
    }

    @Override
    public Optional<GatewayRoute> findById(String id) {
        return Optional.ofNullable(mapper.selectById(id)).map(this::toDomain);
    }

    @Override
    public List<GatewayRoute> findAll() {
        return mapper.selectList(null).stream().map(this::toDomain).toList();
    }

    private GatewayRouteDO toDO(GatewayRoute aggregate) {
        GatewayRouteDO aggregateDO = new GatewayRouteDO();
        aggregateDO.setRouteKey(aggregate.routeKey());
        aggregateDO.setTargetService(aggregate.targetService());
        aggregateDO.setUriPattern(aggregate.uriPattern());
        aggregateDO.setEnabled(aggregate.enabled());
        return aggregateDO;
    }

    private GatewayRoute toDomain(GatewayRouteDO record) {
        return new GatewayRoute(
                record.getRouteKey(),
                record.getTargetService(),
                record.getUriPattern(),
                record.isEnabled()
        );
    }
}
