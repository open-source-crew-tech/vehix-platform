package com.vehix.platform.monitoring.domain.model.valueobjects;

/**
 * Enumeration representing the status of a failure.
 * @summary
 * This enum defines the possible states of a failure in the vehicle system.
 * It is used to track the lifecycle of a failure request.
 * The possible statuses are:
 * - UNDEFINED: Represents an undefined failure status.
 * - FIXED: The failure has been resolved and fixed.
 * - PENDING: The failure is still pending and needs attention.
 * @since 1.0.0
 */
public enum FailureStatus {
    UNDEFINED,
    FIXED,
    PENDING
}
