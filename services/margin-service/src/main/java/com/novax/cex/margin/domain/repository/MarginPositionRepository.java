package com.novax.cex.margin.domain.repository;

import com.novax.cex.margin.domain.model.MarginPosition;
import java.util.List;
import java.util.Optional;

public interface MarginPositionRepository {
    MarginPosition save(MarginPosition aggregate);

    Optional<MarginPosition> findById(String id);

    List<MarginPosition> findAll();
}
