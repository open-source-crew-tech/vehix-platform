package com.vehix.platform.monitoring.interfaces.transform;


import com.vehix.platform.monitoring.domain.model.entities.OdbError;
import com.vehix.platform.monitoring.interfaces.resource.OdbErrorResource;

/**
 * Assembler to convert OdbError entity to OdbErrorResource.
 */
public class OdbErrorResourceFromEntityAssembler {
    public static OdbErrorResource toResourceFromEntity(OdbError odbError) {
        return new OdbErrorResource(
                odbError.getId(),
                odbError.getErrorCode(),
                odbError.getErrorCodeTitle(),
                odbError.getErrorType().toString()
        );
    }
}