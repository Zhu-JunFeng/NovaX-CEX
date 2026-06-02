package com.novax.cex.futures.domain.repository;

import com.novax.cex.futures.domain.model.FuturesPosition;
import java.util.List;
import java.util.Optional;

public interface FuturesPositionRepository {
    FuturesPosition save(FuturesPosition aggregate);

    Optional<FuturesPosition> findById(String id);

    List<FuturesPosition> findAll();
}
