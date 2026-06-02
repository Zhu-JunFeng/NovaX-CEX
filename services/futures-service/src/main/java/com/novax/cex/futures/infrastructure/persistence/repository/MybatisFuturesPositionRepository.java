package com.novax.cex.futures.infrastructure.persistence.repository;

import com.novax.cex.futures.domain.model.FuturesPosition;
import com.novax.cex.futures.domain.repository.FuturesPositionRepository;
import com.novax.cex.futures.infrastructure.persistence.dataobject.FuturesPositionDO;
import com.novax.cex.futures.infrastructure.persistence.mapper.FuturesPositionMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisFuturesPositionRepository implements FuturesPositionRepository {
    private final FuturesPositionMapper mapper;

    public MybatisFuturesPositionRepository(FuturesPositionMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public FuturesPosition save(FuturesPosition aggregate) {
        FuturesPositionDO aggregateDO = toDO(aggregate);
        if (aggregateDO.getId() == null) {
            mapper.insert(aggregateDO);
        } else {
            mapper.updateById(aggregateDO);
        }
        return toDomain(aggregateDO);
    }

    @Override
    public Optional<FuturesPosition> findById(String id) {
        return Optional.ofNullable(mapper.selectById(id)).map(this::toDomain);
    }

    @Override
    public List<FuturesPosition> findAll() {
        return mapper.selectList(null).stream().map(this::toDomain).toList();
    }

    private FuturesPositionDO toDO(FuturesPosition aggregate) {
        FuturesPositionDO aggregateDO = new FuturesPositionDO();
        aggregateDO.setAccountId(aggregate.accountId());
        aggregateDO.setSymbolCode(aggregate.symbolCode());
        aggregateDO.setPositionSide(aggregate.positionSide());
        aggregateDO.setPositionQty(aggregate.positionQty());
        return aggregateDO;
    }

    private FuturesPosition toDomain(FuturesPositionDO record) {
        return new FuturesPosition(
                record.getAccountId(),
                record.getSymbolCode(),
                record.getPositionSide(),
                record.getPositionQty()
        );
    }
}
