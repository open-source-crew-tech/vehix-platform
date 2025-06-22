package com.vehix.platform.monitoring.application.queryservices;

import com.vehix.platform.monitoring.domain.model.aggregates.Failure;
import com.vehix.platform.monitoring.domain.model.queries.GetAllFailuresByErrorTypeQuery;
import com.vehix.platform.monitoring.domain.model.queries.GetAllFailuresQuery;
import com.vehix.platform.monitoring.domain.model.queries.GetFailureByIdQuery;
import com.vehix.platform.monitoring.domain.model.valueobjects.ErrorType;
import com.vehix.platform.monitoring.domain.services.FailureQueryService;
import com.vehix.platform.monitoring.infrastructure.persistence.jpa.repositories.FailureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FailureQueryServiceImpl implements FailureQueryService {

    private final FailureRepository failureRepository;

    public FailureQueryServiceImpl(FailureRepository failureRepository) {
        this.failureRepository = failureRepository;
    }

    @Override
    public Optional<Failure> handle(GetFailureByIdQuery query) {
        return failureRepository.findById((long) query.failureId());
    }

    @Override
    public List<Failure> handle(GetAllFailuresQuery query) {
        return failureRepository.findAll();
    }

    @Override
    public List<Failure> handle(GetAllFailuresByErrorTypeQuery query) {
        return failureRepository.findByErrorType(ErrorType.valueOf(query.errorType()));
    }
}
