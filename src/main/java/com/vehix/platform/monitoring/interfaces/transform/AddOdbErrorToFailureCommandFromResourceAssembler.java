package com.vehix.platform.monitoring.interfaces.transform;

import com.vehix.platform.monitoring.domain.model.commands.AddOdbErrorToFailureCommand;
import com.vehix.platform.monitoring.interfaces.resource.AddOdbErrorToFailureResource;

/**
 * Assembler to convert AddOdbErrorToFailureResource to AddOdbErrorToFailureCommand.
 */
public class AddOdbErrorToFailureCommandFromResourceAssembler {
    public static AddOdbErrorToFailureCommand toCommandFromResource(AddOdbErrorToFailureResource resource, int failureId) {
        return new AddOdbErrorToFailureCommand(resource.errorCode(), resource.errorCodeTitle(), resource.errorType(), failureId);
    }
}