package com.vehix.platform.monitoring.domain.services;

import com.vehix.platform.monitoring.domain.model.commands.CreateOdbErrorCommand;
import com.vehix.platform.monitoring.domain.model.entities.OdbError;

import java.util.Optional;

public interface OdbErrorCommandService {
    Optional<OdbError> handle(CreateOdbErrorCommand command);
}
