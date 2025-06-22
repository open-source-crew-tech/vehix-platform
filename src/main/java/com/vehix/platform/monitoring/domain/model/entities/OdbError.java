package com.vehix.platform.monitoring.domain.model.entities;

import com.vehix.platform.monitoring.domain.model.valueobjects.ErrorType;
import jakarta.persistence.*;
import com.vehix.platform.monitoring.domain.model.commands.CreateOdbErrorCommand;
import lombok.Getter;


@Getter
@Entity
public class OdbError {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String errorCode;
    private String errorCodeTitle;

    private ErrorType type;

    private String errorTypeString;


    protected OdbError() {
        // Default constructor for JPA
    }

    /**
     * Constructs an OdbError with the specified error code, title, and type.
     *
     * @param errorCode       The unique code for the error.
     * @param errorCodeTitle  A descriptive title for the error.
     * @param errorType       The type of the error, must not be null or empty.
     * @throws IllegalArgumentException if any of the parameters are null or empty.
     */
    public OdbError(String errorCode, String errorCodeTitle, String errorType) {
        if (errorCode == null || errorCode.isBlank()) {
            throw new IllegalArgumentException("Error code cannot be null or empty.");
        }
        if (errorCodeTitle == null || errorCodeTitle.isBlank()) {
            throw new IllegalArgumentException("Error code title cannot be null or empty.");
        }
        if (errorType == null || errorType.isBlank()) {
            throw new IllegalArgumentException("Error type cannot be null or empty.");
        }
        this.errorCode = errorCode;
        this.errorCodeTitle = errorCodeTitle;
        this.errorTypeString = errorType;
        this.type = ErrorType.valueOf(errorType.toUpperCase());
    }

    public OdbError(CreateOdbErrorCommand command) {
        this(command.errorCode(), command.errorCodeTitle(), command.errorType());
    }

    public Object getErrorType() {
        if (this.type == null) {
            return this.errorTypeString;
        }
        return this.type.toString();
    }
}
