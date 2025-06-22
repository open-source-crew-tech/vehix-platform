package com.vehix.platform.monitoring.interfaces.transform;

import com.vehix.platform.monitoring.domain.model.commands.CreateFailureCommand;
import com.vehix.platform.monitoring.interfaces.resource.CreateFailureResource;

/**
 * Assembler to convert CreateFailureResource to CreateFailureCommand.
 */
public class CreateFailureCommandFromResourceAssembler {
    public static CreateFailureCommand toCommandFromResource(CreateFailureResource resource) {
        return new CreateFailureCommand(resource.obdErrorId(), resource.badPracticeId(), resource.suggestSolution());
    }
}
