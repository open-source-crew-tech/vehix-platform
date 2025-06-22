package com.vehix.platform.monitoring.domain.model.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class BadPracticeCreatedEvent extends ApplicationEvent {
    private final String descriptionBadPractice;

    /**
     * Constructs a new BadPracticeCreatedEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     * @param descriptionBadPractice a description of the bad practice (must not be null or empty)
     * @throws IllegalArgumentException if descriptionBadPractice is null or empty
     */
    public BadPracticeCreatedEvent(Object source, String descriptionBadPractice) {
        super(source);
        if (descriptionBadPractice == null || descriptionBadPractice.isBlank()) {
            throw new IllegalArgumentException("Description of bad practice cannot be null or empty.");
        }
        this.descriptionBadPractice = descriptionBadPractice;
    }
}
