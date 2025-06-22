package com.vehix.platform.monitoring.interfaces.transform;

import com.vehix.platform.monitoring.domain.model.commands.CreateOdbErrorCommand;
import com.vehix.platform.monitoring.interfaces.resource.CreateOdbErrorResource;

/**
 * Assembler to convert CreateOdbErrorResource to CreateOdbErrorCommand.
 */
public class CreateOdbErrorCommandFromResourceAssembler {
    public static CreateOdbErrorCommand toCommandFromResource(CreateOdbErrorResource resource) {
        return new CreateOdbErrorCommand(resource.errorCode(), resource.errorCodeTitle(), resource.errorType());
    }
}