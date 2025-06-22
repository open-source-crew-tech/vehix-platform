package com.vehix.platform.monitoring.domain.model.valueobjects;

/**
 * Enumeration representing the urgency level of a failure.
 * @summary
 * This enum defines the possible urgency levels of a failure in the vehicle system.
 * It helps prioritize failure resolutions based on their criticality.
 * The possible urgency levels are:
 * - CRITICAL: The failure requires immediate attention.
 * - MODERATE: The failure should be addressed promptly but is not as urgent.
 * - MILD: The failure is minor and can be resolved soon.
 * @since 1.0.0
 */
public enum FailureUrgency {
    CRITICAL,
    MODERATE,
    MILD
}
