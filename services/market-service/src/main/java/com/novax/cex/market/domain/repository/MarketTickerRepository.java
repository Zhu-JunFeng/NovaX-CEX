package com.novax.cex.market.domain.repository;

import com.novax.cex.market.domain.model.MarketTicker;
import java.util.List;
import java.util.Optional;

public interface MarketTickerRepository {
    MarketTicker save(MarketTicker aggregate);

    Optional<MarketTicker> findById(String id);

    List<MarketTicker> findAll();
}
