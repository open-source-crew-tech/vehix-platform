package com.vehix.platform.monitoring.domain.services;

import com.vehix.platform.monitoring.domain.model.commands.CreateBadPracticeCommand;
import com.vehix.platform.monitoring.domain.model.entities.BadPractice;

public interface BadPracticeCommandService {
    BadPractice handle(CreateBadPracticeCommand command);
}
