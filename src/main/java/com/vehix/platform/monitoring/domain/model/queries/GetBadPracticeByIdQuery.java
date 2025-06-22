package com.vehix.platform.monitoring.domain.model.queries;

public record GetBadPracticeByIdQuery(int badPracticeId) {
    /**
     * Query to retrieve a Bad Practice by its ID.
     * @param badPracticeId The ID of the Bad Practice to retrieve.
     * @since 1.0.0
     */
    public GetBadPracticeByIdQuery {
        if (badPracticeId <= 0) {
            throw new IllegalArgumentException("Bad Practice ID must be greater than zero");
        }
    }
}
