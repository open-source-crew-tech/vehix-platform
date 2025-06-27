package com.vehix.platform.monitoring.domain.model.valueobjects;

/**
 * Enumeration representing the type of failure in the system.
 * @summary
 * This enum defines the different categories of failures that can be tracked.
 * The possible failure types are:
 * - SIMPLE: Represents a simple failure that does not require complex solutions.
 * - TECHNICAL: Represents a technical failure that might require professional assistance.
 * - BADPRACTICE: Represents a failure due to improper usage or poor practices.
 * @since 1.0.0
 */
public enum FailureType {
    SIMPLE,
    TECHNICAL,
    BADPRACTICE
}
