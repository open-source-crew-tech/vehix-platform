package com.vehix.platform.monitoring.domain.model.commands;

/**
 * Command to create a new ODB Error.
 * @summary
 * This command is used to create a new ODB error in the system.
 * @param errorCode The error code for the ODB error.
 * @param errorCodeTitle The title of the error code.
 * @param errorType The type of error.
 * @since 1.0.0
 */
public record CreateOdbErrorCommand(String errorCode, String errorCodeTitle, String errorType) {
    public CreateOdbErrorCommand {
        if (errorCode == null || errorCode.isBlank()) {
            throw new IllegalArgumentException("Error code cannot be null or empty");
        }
        if (errorCodeTitle == null || errorCodeTitle.isBlank()) {
            throw new IllegalArgumentException("Error code title cannot be null or empty");
        }
        if (errorType == null || errorType.isBlank()) {
            throw new IllegalArgumentException("Error type cannot be null or empty");
        }
    }
}
