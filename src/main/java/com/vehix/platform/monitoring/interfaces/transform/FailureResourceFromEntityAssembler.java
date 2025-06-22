package com.vehix.platform.monitoring.interfaces.transform;

import com.vehix.platform.monitoring.domain.model.aggregates.Failure;
import com.vehix.platform.monitoring.interfaces.resource.FailureResource;
import com.vehix.platform.monitoring.interfaces.resource.OdbErrorResource;

/**
 * Assembler to convert Failure entity to FailureResource.
 */
public class FailureResourceFromEntityAssembler {
    public static FailureResource toResourceFromEntity(Failure entity) {
        return new FailureResource(
                entity.getId(),
                entity.getSuggestSolution(),
                BadPracticeResourceFromEntityAssembler.toResourceFromEntity(entity.getBadPractice()),
                new OdbErrorResource(2, entity.getOdbError(), "no title", "no type"),
                entity.getStatus().toString(),
                entity.getType().toString(),
                entity.getUrgency().toString()
        );
    }
}