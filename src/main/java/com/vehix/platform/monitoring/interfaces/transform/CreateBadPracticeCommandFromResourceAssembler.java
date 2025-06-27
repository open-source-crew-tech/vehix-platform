package com.vehix.platform.monitoring.interfaces.transform;

import com.vehix.platform.monitoring.domain.model.commands.CreateBadPracticeCommand;
import com.vehix.platform.monitoring.interfaces.resource.CreateBadPracticeResource;

/**
 * Assembler to convert CreateBadPracticeResource to CreateBadPracticeCommand.
 */
public class CreateBadPracticeCommandFromResourceAssembler {
    public static CreateBadPracticeCommand toCommandFromResource(CreateBadPracticeResource resource) {
        return new CreateBadPracticeCommand(resource.descriptionBadPractice());
    }
}