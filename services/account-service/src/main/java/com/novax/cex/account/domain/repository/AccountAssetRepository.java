package com.novax.cex.account.domain.repository;

import com.novax.cex.account.domain.model.AccountAsset;
import java.util.List;
import java.util.Optional;

public interface AccountAssetRepository {
    AccountAsset save(AccountAsset aggregate);

    Optional<AccountAsset> findById(String id);

    List<AccountAsset> findAll();
}
