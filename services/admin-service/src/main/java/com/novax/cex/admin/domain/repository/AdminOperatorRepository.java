package com.novax.cex.admin.domain.repository;

import com.novax.cex.admin.domain.model.AdminOperator;
import java.util.List;
import java.util.Optional;

public interface AdminOperatorRepository {
    AdminOperator save(AdminOperator aggregate);

    Optional<AdminOperator> findById(String id);

    List<AdminOperator> findAll();
}
