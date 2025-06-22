package com.vehix.platform.monitoring.domain.model.commands;

/**
 * Command to create a new Failure.
 * @summary
 * This command is used to create a new failure in the system, associating it with an ODB error and a bad practice.
 * @param odbErrorId The ID of the associated ODB error.
 * @param badPracticeId The ID of the associated bad practice.
 * @param suggestSolution The suggested solution for the failure.
 * @since 1.0.0
 */
public record CreateFailureCommand(int odbErrorId, int badPracticeId, String suggestSolution) {
    public CreateFailureCommand {
        if (odbErrorId <= 0) {
            throw new IllegalArgumentException("ODB Error ID must be a positive integer");
        }
        if (badPracticeId <= 0) {
            throw new IllegalArgumentException("Bad Practice ID must be a positive integer");
        }
        if (suggestSolution == null || suggestSolution.isBlank()) {
            throw new IllegalArgumentException("Suggested solution cannot be null or empty");
        }
    }
}
