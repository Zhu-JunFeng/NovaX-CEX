package com.novax.cex.clearing.infrastructure.persistence.repository;

import com.novax.cex.clearing.domain.model.ClearingRecord;
import com.novax.cex.clearing.domain.repository.ClearingRecordRepository;
import com.novax.cex.clearing.infrastructure.persistence.dataobject.ClearingRecordDO;
import com.novax.cex.clearing.infrastructure.persistence.mapper.ClearingRecordMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisClearingRecordRepository implements ClearingRecordRepository {
    private final ClearingRecordMapper mapper;

    public MybatisClearingRecordRepository(ClearingRecordMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ClearingRecord save(ClearingRecord aggregate) {
        ClearingRecordDO aggregateDO = toDO(aggregate);
        if (aggregateDO.getId() == null) {
            mapper.insert(aggregateDO);
        } else {
            mapper.updateById(aggregateDO);
        }
        return toDomain(aggregateDO);
    }

    @Override
    public Optional<ClearingRecord> findById(String id) {
        return Optional.ofNullable(mapper.selectById(id)).map(this::toDomain);
    }

    @Override
    public List<ClearingRecord> findAll() {
        return mapper.selectList(null).stream().map(this::toDomain).toList();
    }

    private ClearingRecordDO toDO(ClearingRecord aggregate) {
        ClearingRecordDO aggregateDO = new ClearingRecordDO();
        aggregateDO.setBizId(aggregate.bizId());
        aggregateDO.setAccountId(aggregate.accountId());
        aggregateDO.setAssetCode(aggregate.assetCode());
        aggregateDO.setAmount(aggregate.amount());
        return aggregateDO;
    }

    private ClearingRecord toDomain(ClearingRecordDO record) {
        return new ClearingRecord(
                record.getBizId(),
                record.getAccountId(),
                record.getAssetCode(),
                record.getAmount()
        );
    }
}
