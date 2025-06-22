package com.vehix.platform.monitoring.domain.model.commands;

/**
 * Command to add an ODB error to a specific failure.
 * @summary
 * This command is used to associate an ODB error with a specific failure in the system.
 * @param errorCode The error code.
 * @param errorCodeTitle The title of the error code.
 * @param errorType The type of error.
 * @param failureId The ID of the failure to which the ODB error will be associated.
 * @since 1.0.0
 */
public record AddOdbErrorToFailureCommand(String errorCode, String errorCodeTitle, String errorType, int failureId) {
    public AddOdbErrorToFailureCommand {
        if (errorCode == null || errorCode.isBlank()) {
            throw new IllegalArgumentException("Error code cannot be null or empty");
        }
        if (errorCodeTitle == null || errorCodeTitle.isBlank()) {
            throw new IllegalArgumentException("Error code title cannot be null or empty");
        }
        if (errorType == null || errorType.isBlank()) {
            throw new IllegalArgumentException("Error type cannot be null or empty");
        }
        if (failureId <= 0) {
            throw new IllegalArgumentException("Failure ID must be a positive integer");
        }
    }
}
