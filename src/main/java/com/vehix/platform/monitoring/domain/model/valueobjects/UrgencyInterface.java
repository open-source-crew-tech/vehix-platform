package com.vehix.platform.monitoring.domain.model.valueobjects;

/**
 * Interface for changing the urgency of a failure.
 * @summary
 * This interface defines methods for changing the urgency of a failure.
 * The urgency indicates how quickly the failure needs to be addressed, from critical to mild.
 * @since 1.0.0
 */
public interface UrgencyInterface {
    void changeToCritical();
    void changeToModerate();
    void changeToMild();
}
