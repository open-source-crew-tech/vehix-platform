package com.vehix.platform.monitoring.domain.model.commands;

/**
 * Command to create a new Bad Practice.
 * @summary
 * This command is used to create a new bad practice in the system.
 * @param descriptionBadPractice The description of the bad practice to be created.
 * @since 1.0.0
 */
public record CreateBadPracticeCommand(String descriptionBadPractice) {
    public CreateBadPracticeCommand {
        if (descriptionBadPractice == null || descriptionBadPractice.isBlank()) {
            throw new IllegalArgumentException("Description of bad practice cannot be null or empty");
        }
    }
}
