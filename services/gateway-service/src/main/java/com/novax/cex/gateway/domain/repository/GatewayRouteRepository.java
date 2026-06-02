package com.novax.cex.gateway.domain.repository;

import com.novax.cex.gateway.domain.model.GatewayRoute;
import java.util.List;
import java.util.Optional;

public interface GatewayRouteRepository {
    GatewayRoute save(GatewayRoute aggregate);

    Optional<GatewayRoute> findById(String id);

    List<GatewayRoute> findAll();
}
