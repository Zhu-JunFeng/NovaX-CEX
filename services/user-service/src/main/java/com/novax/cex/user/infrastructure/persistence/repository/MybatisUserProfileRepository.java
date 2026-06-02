package com.novax.cex.user.infrastructure.persistence.repository;

import com.novax.cex.user.domain.model.UserProfile;
import com.novax.cex.user.domain.repository.UserProfileRepository;
import com.novax.cex.user.infrastructure.persistence.dataobject.UserProfileDO;
import com.novax.cex.user.infrastructure.persistence.mapper.UserProfileMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisUserProfileRepository implements UserProfileRepository {
    private final UserProfileMapper mapper;

    public MybatisUserProfileRepository(UserProfileMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public UserProfile save(UserProfile aggregate) {
        UserProfileDO aggregateDO = toDO(aggregate);
        if (aggregateDO.getId() == null) {
            mapper.insert(aggregateDO);
        } else {
            mapper.updateById(aggregateDO);
        }
        return toDomain(aggregateDO);
    }

    @Override
    public Optional<UserProfile> findById(String id) {
        return Optional.ofNullable(mapper.selectById(id)).map(this::toDomain);
    }

    @Override
    public List<UserProfile> findAll() {
        return mapper.selectList(null).stream().map(this::toDomain).toList();
    }

    private UserProfileDO toDO(UserProfile aggregate) {
        UserProfileDO aggregateDO = new UserProfileDO();
        aggregateDO.setUserNo(aggregate.userNo());
        aggregateDO.setDisplayName(aggregate.displayName());
        aggregateDO.setKycLevel(aggregate.kycLevel());
        aggregateDO.setStatus(aggregate.status());
        return aggregateDO;
    }

    private UserProfile toDomain(UserProfileDO record) {
        return new UserProfile(
                record.getUserNo(),
                record.getDisplayName(),
                record.getKycLevel(),
                record.getStatus()
        );
    }
}
