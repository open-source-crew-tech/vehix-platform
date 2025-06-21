package com.vehix.platform.monitoring.domain.model.commands;

/**
 * Command to add a bad practice to a specific failure.
 * @summary
 * This command is used to associate a bad practice with a specific failure in the system.
 * @param descriptionBadPractice The description of the bad practice to be added.
 * @param failureId The ID of the failure to which the bad practice will be associated.
 * @since 1.0.0
 */
public record AddBadPracticeToFailureCommand(String descriptionBadPractice, int failureId) {
    public AddBadPracticeToFailureCommand {
        if (descriptionBadPractice == null || descriptionBadPractice.isBlank()) {
            throw new IllegalArgumentException("Description of bad practice cannot be null or empty");
        }
        if (failureId <= 0) {
            throw new IllegalArgumentException("Failure ID must be a positive integer");
        }
    }
}
