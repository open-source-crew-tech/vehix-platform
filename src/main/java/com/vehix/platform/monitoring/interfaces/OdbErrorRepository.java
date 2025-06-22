package com.vehix.platform.monitoring.interfaces;

import com.vehix.platform.monitoring.domain.model.entities.OdbError;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OdbErrorRepository extends JpaRepository<OdbError, Long> {
    Optional<OdbError> findByErrorCode(String errorCode);
    boolean existsByErrorCode(String errorCode);
}