package com.vehix.platform.monitoring.domain.model.events;

import com.vehix.platform.monitoring.domain.model.commands.CreateBadPracticeCommand;
import com.vehix.platform.monitoring.domain.model.entities.BadPractice;
import com.vehix.platform.monitoring.infrastructure.persistence.jpa.repositories.BadPracticeRepository;
import jakarta.transaction.Transactional;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.util.Optional;

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
