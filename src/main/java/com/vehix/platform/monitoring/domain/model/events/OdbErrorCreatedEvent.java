package com.vehix.platform.monitoring.domain.model.events;

import org.springframework.context.ApplicationEvent;

public class OdbErrorCreatedEvent extends ApplicationEvent {
    private final String errorCode;
    private final String errorCodeTitle;

    /**
     * Constructs a new OdbErrorCreatedEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     * @param errorCode the error code associated with the event (must not be null or empty)
     * @param errorCodeTitle the title of the error code (must not be null or empty)
     * @throws IllegalArgumentException if errorCode or errorCodeTitle is null or empty
     */
    public OdbErrorCreatedEvent(Object source, String errorCode, String errorCodeTitle) {
        super(source);
        if (errorCode == null || errorCode.isBlank()) {
            throw new IllegalArgumentException("Error code cannot be null or empty.");
        }
        if (errorCodeTitle == null || errorCodeTitle.isBlank()) {
            throw new IllegalArgumentException("Error code title cannot be null or empty.");
        }
        this.errorCode = errorCode;
        this.errorCodeTitle = errorCodeTitle;
    }
}
