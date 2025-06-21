package com.vehix.platform.monitoring.domain.model.queries;

public record GetFailureByIdQuery(int failureId) {
    /**
     * Query to retrieve a Failure by its ID.
     * @param failureId The ID of the Failure to retrieve.
     * @since 1.0.0
     */
    public GetFailureByIdQuery {
        if (failureId <= 0) {
            throw new IllegalArgumentException("Failure ID must be greater than zero");
        }
    }
}
