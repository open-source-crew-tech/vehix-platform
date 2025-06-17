package com.vehix.platform.monitoring.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Value Object representing a Vehicle ID.
 * @summary
 * Represents a unique identifier for a vehicle.
 * This class is immutable and ensures that the vehicle ID is always a positive number.
 * @param vehicleId the unique identifier for the vehicle that must be a positive number.
 * @see IllegalArgumentException
 * @since 1.0.0
 */
@Embeddable
public record VehicleId(Long vehicleId) {
    public VehicleId {
        if(vehicleId == null || vehicleId <= 0) {
            throw new IllegalArgumentException("Vehicle ID must be a positive number.");
        }
    }
}
