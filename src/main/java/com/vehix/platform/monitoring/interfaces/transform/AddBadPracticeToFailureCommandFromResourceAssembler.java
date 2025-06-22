package com.vehix.platform.monitoring.interfaces.transform;

import com.vehix.platform.monitoring.domain.model.commands.AddBadPracticeToFailureCommand;
import com.vehix.platform.monitoring.interfaces.resource.AddBadPracticeToFailureResource;

/**
 * Assembler to convert AddBadPracticeToFailureResource to AddBadPracticeToFailureCommand.
 */
public class AddBadPracticeToFailureCommandFromResourceAssembler {
    public static AddBadPracticeToFailureCommand toCommandFromResource(AddBadPracticeToFailureResource resource, int failureId) {
        return new AddBadPracticeToFailureCommand(resource.descriptionBadPractice(), failureId);
    }
}
