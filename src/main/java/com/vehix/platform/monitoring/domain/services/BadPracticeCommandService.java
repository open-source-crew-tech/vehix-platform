package com.vehix.platform.monitoring.domain.services;

import com.vehix.platform.monitoring.domain.model.commands.CreateBadPracticeCommand;
import com.vehix.platform.monitoring.domain.model.entities.BadPractice;

import java.util.Optional;

public interface BadPracticeCommandService {
    Optional<BadPractice> handle(CreateBadPracticeCommand command);
}
