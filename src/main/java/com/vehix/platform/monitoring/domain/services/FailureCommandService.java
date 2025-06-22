package com.vehix.platform.monitoring.domain.services;

import com.vehix.platform.monitoring.domain.model.aggregates.Failure;
import com.vehix.platform.monitoring.domain.model.commands.AddBadPracticeToFailureCommand;
import com.vehix.platform.monitoring.domain.model.commands.AddOdbErrorToFailureCommand;
import com.vehix.platform.monitoring.domain.model.commands.CreateFailureCommand;

import java.util.Optional;

public interface FailureCommandService {
    Optional<Failure> handle(CreateFailureCommand command);
    Optional<Failure> handle(AddBadPracticeToFailureCommand command);
    Optional<Failure> handle(AddOdbErrorToFailureCommand command);
}
