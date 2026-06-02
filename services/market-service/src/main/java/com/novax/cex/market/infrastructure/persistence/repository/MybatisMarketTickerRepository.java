package com.novax.cex.market.infrastructure.persistence.repository;

import com.novax.cex.market.domain.model.MarketTicker;
import com.novax.cex.market.domain.repository.MarketTickerRepository;
import com.novax.cex.market.infrastructure.persistence.dataobject.MarketTickerDO;
import com.novax.cex.market.infrastructure.persistence.mapper.MarketTickerMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisMarketTickerRepository implements MarketTickerRepository {
    private final MarketTickerMapper mapper;

    public MybatisMarketTickerRepository(MarketTickerMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public MarketTicker save(MarketTicker aggregate) {
        MarketTickerDO aggregateDO = toDO(aggregate);
        if (aggregateDO.getId() == null) {
            mapper.insert(aggregateDO);
        } else {
            mapper.updateById(aggregateDO);
        }
        return toDomain(aggregateDO);
    }

    @Override
    public Optional<MarketTicker> findById(String id) {
        return Optional.ofNullable(mapper.selectById(id)).map(this::toDomain);
    }

    @Override
    public List<MarketTicker> findAll() {
        return mapper.selectList(null).stream().map(this::toDomain).toList();
    }

    private MarketTickerDO toDO(MarketTicker aggregate) {
        MarketTickerDO aggregateDO = new MarketTickerDO();
        aggregateDO.setSymbolCode(aggregate.symbolCode());
        aggregateDO.setLastPrice(aggregate.lastPrice());
        aggregateDO.setMarkPrice(aggregate.markPrice());
        aggregateDO.setStatus(aggregate.status());
        return aggregateDO;
    }

    private MarketTicker toDomain(MarketTickerDO record) {
        return new MarketTicker(
                record.getSymbolCode(),
                record.getLastPrice(),
                record.getMarkPrice(),
                record.getStatus()
        );
    }
}
