package com.vehix.platform.monitoring.domain.services;

import com.vehix.platform.monitoring.domain.model.aggregates.Failure;
import com.vehix.platform.monitoring.domain.model.queries.GetAllFailuresByErrorTypeQuery;
import com.vehix.platform.monitoring.domain.model.queries.GetAllFailuresQuery;
import com.vehix.platform.monitoring.domain.model.queries.GetFailureByIdQuery;

import java.util.List;
import java.util.Optional;

public interface FailureQueryService {
    Optional<Failure> handle(GetFailureByIdQuery query);
    List<Failure> handle(GetAllFailuresQuery query);
    List<Failure> handle(GetAllFailuresByErrorTypeQuery query);
}
