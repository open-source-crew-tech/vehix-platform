package com.vehix.platform.monitoring.domain.model.valueobjects;

/**
 * Interface for state transitions of a failure in the vehicle system.
 * @summary
 * This interface defines methods for changing the state of a failure.
 * The states represent the current condition of the failure, such as whether it has been fixed or is still pending.
 * @since 1.0.0
 */
public interface StateInterface {
    void changeToFixed();
    void changeToPending();
}
