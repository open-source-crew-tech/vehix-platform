package com.vehix.platform.monitoring.domain.model.valueobjects;

/**
 * Enumeration representing different types of errors in the system.
 * @summary
 * This enum defines the various error types that can occur in the system.
 * Each error type represents a category of failure in the vehicle system.
 * The possible error types are:
 * - UNDEFINED: Represents an undefined error type.
 * - POWERTRAIN: Represents errors related to the vehicle's powertrain system.
 * - CHASSIS: Represents errors related to the vehicle's chassis.
 * - BODY: Represents errors related to the vehicle's body.
 * - NETWORK: Represents errors related to the vehicle's network system.
 * @since 1.0.0
 */
public enum ErrorType {
    UNDEFINED,
    POWERTRAIN,
    CHASSIS,
    BODY,
    NETWORK
}
