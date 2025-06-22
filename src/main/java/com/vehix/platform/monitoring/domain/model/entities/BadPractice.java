package com.vehix.platform.monitoring.domain.model.entities;


import jakarta.persistence.*;
import lombok.Getter;
import com.vehix.platform.monitoring.domain.model.commands.CreateBadPracticeCommand;

/**
 * Represents a bad practice in the system.
 * This entity is used to track and manage bad practices identified in the system.
 */
@Getter
@Entity
public class BadPractice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private final String descriptionBadPractice;

    protected BadPractice() {
        this.descriptionBadPractice = "";
    }

    public BadPractice(String descriptionBadPractice) {
        if (descriptionBadPractice == null || descriptionBadPractice.isBlank()) {
            throw new IllegalArgumentException("Description of Bad Practice cannot be null or empty.");
        }
        this.descriptionBadPractice = descriptionBadPractice;
    }

    public BadPractice(CreateBadPracticeCommand command) {
        this(command.descriptionBadPractice());
    }

    public boolean isEmpty() {
        return this.descriptionBadPractice == null || this.descriptionBadPractice.isBlank();
    }
}
