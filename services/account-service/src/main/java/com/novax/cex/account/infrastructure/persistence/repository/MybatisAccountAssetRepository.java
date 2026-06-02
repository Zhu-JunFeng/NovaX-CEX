package com.novax.cex.account.infrastructure.persistence.repository;

import com.novax.cex.account.domain.model.AccountAsset;
import com.novax.cex.account.domain.repository.AccountAssetRepository;
import com.novax.cex.account.infrastructure.persistence.dataobject.AccountAssetDO;
import com.novax.cex.account.infrastructure.persistence.mapper.AccountAssetMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisAccountAssetRepository implements AccountAssetRepository {
    private final AccountAssetMapper mapper;

    public MybatisAccountAssetRepository(AccountAssetMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public AccountAsset save(AccountAsset aggregate) {
        AccountAssetDO aggregateDO = toDO(aggregate);
        if (aggregateDO.getId() == null) {
            mapper.insert(aggregateDO);
        } else {
            mapper.updateById(aggregateDO);
        }
        return toDomain(aggregateDO);
    }

    @Override
    public Optional<AccountAsset> findById(String id) {
        return Optional.ofNullable(mapper.selectById(id)).map(this::toDomain);
    }

    @Override
    public List<AccountAsset> findAll() {
        return mapper.selectList(null).stream().map(this::toDomain).toList();
    }

    private AccountAssetDO toDO(AccountAsset aggregate) {
        AccountAssetDO aggregateDO = new AccountAssetDO();
        aggregateDO.setAccountId(aggregate.accountId());
        aggregateDO.setAssetCode(aggregate.assetCode());
        aggregateDO.setAvailableBalance(aggregate.availableBalance());
        aggregateDO.setFrozenBalance(aggregate.frozenBalance());
        return aggregateDO;
    }

    private AccountAsset toDomain(AccountAssetDO record) {
        return new AccountAsset(
                record.getAccountId(),
                record.getAssetCode(),
                record.getAvailableBalance(),
                record.getFrozenBalance()
        );
    }
}
