package com.vehix.platform.monitoring.domain.model.valueobjects;

/**
 * Interface for error types that can be sent to different components of the vehicle system.
 * @summary
 * This interface defines methods for sending an error to various subsystems of the vehicle.
 * The methods allow the error to be routed to specific components like the powertrain, chassis, body, and network.
 * @since 1.0.0
 */
public interface ErrorTypeInterface {
    void sendToPowertrain();
    void sendToChassis();
    void sendToBody();
    void sendToNetwork();
}
