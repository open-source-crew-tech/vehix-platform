package com.vehix.platform.monitoring.domain.services;

import com.vehix.platform.monitoring.domain.model.entities.OdbError;
import com.vehix.platform.monitoring.domain.model.queries.GetAllOdbErrorsQuery;
import com.vehix.platform.monitoring.domain.model.queries.GetOdbErrorByIdQuery;

import java.util.List;
import java.util.Optional;

public interface OdbErrorQueryService {
    Optional<OdbError> handle(GetOdbErrorByIdQuery query);
    List<OdbError> handle(GetAllOdbErrorsQuery query);
}
