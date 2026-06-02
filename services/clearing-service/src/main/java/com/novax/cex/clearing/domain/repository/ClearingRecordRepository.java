package com.novax.cex.clearing.domain.repository;

import com.novax.cex.clearing.domain.model.ClearingRecord;
import java.util.List;
import java.util.Optional;

public interface ClearingRecordRepository {
    ClearingRecord save(ClearingRecord aggregate);

    Optional<ClearingRecord> findById(String id);

    List<ClearingRecord> findAll();
}
