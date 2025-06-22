package com.vehix.platform.monitoring.domain.model.aggregates;

import com.vehix.platform.monitoring.domain.model.commands.CreateFailureCommand;
import com.vehix.platform.monitoring.domain.model.entities.BadPractice;
import com.vehix.platform.monitoring.domain.model.entities.OdbError;
import com.vehix.platform.monitoring.domain.model.valueobjects.FailureStatus;
import com.vehix.platform.monitoring.domain.model.valueobjects.FailureType;
import com.vehix.platform.monitoring.domain.model.valueobjects.FailureUrgency;
import com.vehix.platform.monitoring.domain.model.valueobjects.VehicleId;
import com.vehix.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Failure extends AuditableAbstractAggregateRoot<Failure> {
    @Column(nullable = false)
    private String suggestSolution;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bad_practice_id")
    private BadPractice badPractice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "odb_error_id")
    private OdbError odbError;

    @Embedded
    private VehicleId vehicleId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FailureStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FailureType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FailureUrgency urgency;


    protected Failure() {
        this.suggestSolution = "";
        this.vehicleId = null;
        this.status = FailureStatus.UNDEFINED;
        this.type = FailureType.SIMPLE;
        this.urgency = FailureUrgency.MILD;

    }


    /**
     * Constructor for creating a Failure with all required fields.
     *
     * @param badPractice The BadPractice entity associated with the failure.
     * @param odbError The OdbError entity associated with the failure.
     * @param suggestSolution Suggested solution for the failure.
     * @param vehicleId The VehicleId associated with the failure.
     */
    public Failure(BadPractice badPractice, OdbError odbError, String suggestSolution, VehicleId vehicleId) {
        this();
        if (badPractice == null) {
            throw new IllegalArgumentException("BadPractice cannot be null.");
        }
        if (odbError == null) {
            throw new IllegalArgumentException("OdbError cannot be null.");
        }
        if (suggestSolution == null || suggestSolution.isBlank()) {
            throw new IllegalArgumentException("Suggested solution cannot be null or empty.");
        }
        if (vehicleId == null) {
            throw new IllegalArgumentException("Vehicle ID cannot be null.");
        }

        this.badPractice = badPractice;
        this.odbError = odbError;
        this.suggestSolution = suggestSolution;
        this.vehicleId = vehicleId;

    }

    /**
     * Constructor for creating a Failure with a command object.
     * This constructor is typically used in an application service to create a new Failure.
     *
     * @param command The CreateFailureCommand containing the necessary data to create a Failure.
     */
    public Failure(CreateFailureCommand command) {
        this();
        this.suggestSolution = command.suggestSolution();
    }


    /**
     * Adds a bad practice to the failure.
     * This method assumes that a BadPractice entity is being passed,
     * which would typically be retrieved from a repository in an application service.
     *
     * @param badPractice The BadPractice entity to associate.
     */
    public void addBadPracticeToFailure(BadPractice badPractice) {
        if (badPractice == null) {
            throw new IllegalArgumentException("Bad practice to add cannot be null.");
        }
        this.badPractice = badPractice;
    }

    /**
     * Adds an ODB error to the failure.
     * This method assumes that an OdbError entity is being passed,
     * which would typically be retrieved from a repository in an application service.
     *
     * @param odbError The OdbError entity to associate.
     */
    public void addOdbErrorToFailure(OdbError odbError) {
        if (odbError == null) {
            throw new IllegalArgumentException("ODB error to add cannot be null.");
        }
        this.odbError = odbError;
    }


    public void changeToFixed() {
        this.status = FailureStatus.FIXED;
    }

    public void changeToPending() {
        this.status = FailureStatus.PENDING;
    }

    public void changeToSimple() {
        this.type = FailureType.SIMPLE;
    }

    public void changeToTechnical() {
        this.type = FailureType.TECHNICAL;
    }

    public void changeToBadPractice() {
        this.type = FailureType.BADPRACTICE;
    }

    public void changeToCritical() {
        this.urgency = FailureUrgency.CRITICAL;
    }

    public void changeToModerate() {
        this.urgency = FailureUrgency.MODERATE;
    }

    public void changeToMild() {
        this.urgency = FailureUrgency.MILD;
    }
}
