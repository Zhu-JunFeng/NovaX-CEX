package com.novax.cex.wallet.domain.repository;

import com.novax.cex.wallet.domain.model.WalletTransaction;
import java.util.List;
import java.util.Optional;

public interface WalletTransactionRepository {
    WalletTransaction save(WalletTransaction aggregate);

    Optional<WalletTransaction> findById(String id);

    List<WalletTransaction> findAll();
}
