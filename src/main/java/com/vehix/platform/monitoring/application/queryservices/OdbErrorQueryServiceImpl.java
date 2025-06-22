package com.vehix.platform.monitoring.application.queryservices;

import com.vehix.platform.monitoring.domain.model.entities.OdbError;
import com.vehix.platform.monitoring.domain.model.queries.GetAllOdbErrorsQuery;
import com.vehix.platform.monitoring.domain.model.queries.GetOdbErrorByIdQuery;
import com.vehix.platform.monitoring.domain.services.OdbErrorQueryService;
import com.vehix.platform.monitoring.infrastructure.persistence.jpa.repositories.OdbErrorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdbErrorQueryServiceImpl implements OdbErrorQueryService {

    private final OdbErrorRepository odbErrorRepository;

    public OdbErrorQueryServiceImpl(OdbErrorRepository odbErrorRepository) {
        this.odbErrorRepository = odbErrorRepository;
    }

    @Override
    public Optional<OdbError> handle(GetOdbErrorByIdQuery query) {
        return odbErrorRepository.findById((long) query.odbErrorId());
    }

    @Override
    public List<OdbError> handle(GetAllOdbErrorsQuery query) {
        return odbErrorRepository.findAll();
    }
}