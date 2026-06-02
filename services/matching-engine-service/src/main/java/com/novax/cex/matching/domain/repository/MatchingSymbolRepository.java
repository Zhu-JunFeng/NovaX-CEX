package com.novax.cex.matching.domain.repository;

import com.novax.cex.matching.domain.model.MatchingSymbol;
import java.util.List;
import java.util.Optional;

public interface MatchingSymbolRepository {
    MatchingSymbol save(MatchingSymbol aggregate);

    Optional<MatchingSymbol> findById(String id);

    List<MatchingSymbol> findAll();
}
