package com.novax.cex.wallet.infrastructure.persistence.repository;

import com.novax.cex.wallet.domain.model.WalletTransaction;
import com.novax.cex.wallet.domain.repository.WalletTransactionRepository;
import com.novax.cex.wallet.infrastructure.persistence.dataobject.WalletTransactionDO;
import com.novax.cex.wallet.infrastructure.persistence.mapper.WalletTransactionMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisWalletTransactionRepository implements WalletTransactionRepository {
    private final WalletTransactionMapper mapper;

    public MybatisWalletTransactionRepository(WalletTransactionMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public WalletTransaction save(WalletTransaction aggregate) {
        WalletTransactionDO aggregateDO = toDO(aggregate);
        if (aggregateDO.getId() == null) {
            mapper.insert(aggregateDO);
        } else {
            mapper.updateById(aggregateDO);
        }
        return toDomain(aggregateDO);
    }

    @Override
    public Optional<WalletTransaction> findById(String id) {
        return Optional.ofNullable(mapper.selectById(id)).map(this::toDomain);
    }

    @Override
    public List<WalletTransaction> findAll() {
        return mapper.selectList(null).stream().map(this::toDomain).toList();
    }

    private WalletTransactionDO toDO(WalletTransaction aggregate) {
        WalletTransactionDO aggregateDO = new WalletTransactionDO();
        aggregateDO.setWalletTxNo(aggregate.walletTxNo());
        aggregateDO.setAssetCode(aggregate.assetCode());
        aggregateDO.setDirection(aggregate.direction());
        aggregateDO.setAmount(aggregate.amount());
        return aggregateDO;
    }

    private WalletTransaction toDomain(WalletTransactionDO record) {
        return new WalletTransaction(
                record.getWalletTxNo(),
                record.getAssetCode(),
                record.getDirection(),
                record.getAmount()
        );
    }
}
