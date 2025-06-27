package com.vehix.platform.monitoring.domain.model.queries;

public record GetAllFailuresByErrorTypeQuery(String errorType) {
    /**
     * Query to retrieve all failures by error type.
     * @param errorType The type of error to filter failures by.
     * @since 1.0.0
     */
    public GetAllFailuresByErrorTypeQuery {
        if (errorType == null || errorType.isBlank()) {
            throw new IllegalArgumentException("Error type must not be null or blank");
        }
    }
}
