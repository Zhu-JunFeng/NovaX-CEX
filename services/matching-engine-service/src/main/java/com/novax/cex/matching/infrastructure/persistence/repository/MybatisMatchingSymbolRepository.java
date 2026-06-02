package com.novax.cex.matching.infrastructure.persistence.repository;

import com.novax.cex.matching.domain.model.MatchingSymbol;
import com.novax.cex.matching.domain.repository.MatchingSymbolRepository;
import com.novax.cex.matching.infrastructure.persistence.dataobject.MatchingSymbolDO;
import com.novax.cex.matching.infrastructure.persistence.mapper.MatchingSymbolMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisMatchingSymbolRepository implements MatchingSymbolRepository {
    private final MatchingSymbolMapper mapper;

    public MybatisMatchingSymbolRepository(MatchingSymbolMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public MatchingSymbol save(MatchingSymbol aggregate) {
        MatchingSymbolDO aggregateDO = toDO(aggregate);
        if (aggregateDO.getId() == null) {
            mapper.insert(aggregateDO);
        } else {
            mapper.updateById(aggregateDO);
        }
        return toDomain(aggregateDO);
    }

    @Override
    public Optional<MatchingSymbol> findById(String id) {
        return Optional.ofNullable(mapper.selectById(id)).map(this::toDomain);
    }

    @Override
    public List<MatchingSymbol> findAll() {
        return mapper.selectList(null).stream().map(this::toDomain).toList();
    }

    private MatchingSymbolDO toDO(MatchingSymbol aggregate) {
        MatchingSymbolDO aggregateDO = new MatchingSymbolDO();
        aggregateDO.setSymbolCode(aggregate.symbolCode());
        aggregateDO.setBaseAsset(aggregate.baseAsset());
        aggregateDO.setQuoteAsset(aggregate.quoteAsset());
        aggregateDO.setStatus(aggregate.status());
        return aggregateDO;
    }

    private MatchingSymbol toDomain(MatchingSymbolDO record) {
        return new MatchingSymbol(
                record.getSymbolCode(),
                record.getBaseAsset(),
                record.getQuoteAsset(),
                record.getStatus()
        );
    }
}
