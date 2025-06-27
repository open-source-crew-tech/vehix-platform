package com.vehix.platform.monitoring.interfaces.transform;

import com.vehix.platform.monitoring.domain.model.entities.BadPractice;
import com.vehix.platform.monitoring.interfaces.resource.BadPracticeResource;

/**
 * Assembler to convert BadPractice entity to BadPracticeResource.
 */
public class BadPracticeResourceFromEntityAssembler {
    public static BadPracticeResource toResourceFromEntity(BadPractice badPractice) {
        return new BadPracticeResource(Math.toIntExact(badPractice.getId()), badPractice.getDescriptionBadPractice());
    }

    public static Object toResourceFromEntity(String badPractice) {
        return new BadPracticeResource(0, badPractice);
    }
}
