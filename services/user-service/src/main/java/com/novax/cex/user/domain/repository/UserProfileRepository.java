package com.novax.cex.user.domain.repository;

import com.novax.cex.user.domain.model.UserProfile;
import java.util.List;
import java.util.Optional;

public interface UserProfileRepository {
    UserProfile save(UserProfile aggregate);

    Optional<UserProfile> findById(String id);

    List<UserProfile> findAll();
}
