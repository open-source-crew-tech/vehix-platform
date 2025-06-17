package com.vehix.platform.monitoring.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Value Object representing a failure ID.
 * @summary
 * Represents a unique identifier for a vehicle failure.
 * This class is immutable and ensures that the failure ID is always a positive number.
 * @param failureId the unique identifier for the failure that must be a positive number.
 * @see IllegalArgumentException
 * @since 1.0.0
 */
@Embeddable
public record FailureId(Long failureId) {
    public FailureId {
        if(failureId == null || failureId <= 0) {
            throw new IllegalArgumentException("Failure ID must be a positive number.");
        }
    }
}
