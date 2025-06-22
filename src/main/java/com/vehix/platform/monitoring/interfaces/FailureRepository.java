package com.vehix.platform.monitoring.interfaces;

import com.vehix.platform.monitoring.domain.model.aggregates.Failure;
import com.vehix.platform.monitoring.domain.model.valueobjects.ErrorType;
import com.vehix.platform.monitoring.domain.model.valueobjects.FailureStatus;
import com.vehix.platform.monitoring.domain.model.valueobjects.FailureType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FailureRepository extends JpaRepository<Failure, Long> {
    List<Failure> findAllByOdbError_Type(ErrorType errorType);
    List<Failure> findAllBySuggestSolution(String suggestSolution);
    List<Failure> findAllByStatus(FailureStatus status);
    List<Failure> findAllByType(FailureType type);
}