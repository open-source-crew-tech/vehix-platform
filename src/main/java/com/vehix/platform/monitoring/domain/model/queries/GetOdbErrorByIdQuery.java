package com.vehix.platform.monitoring.domain.model.queries;

public record GetOdbErrorByIdQuery(int odbErrorId) {
    /**
     * Query to retrieve an ODB Error by its ID.
     * @param odbErrorId The ID of the ODB Error to retrieve.
     * @since 1.0.0
     */
    public GetOdbErrorByIdQuery {
        if (odbErrorId <= 0) {
            throw new IllegalArgumentException("ODB Error ID must be greater than zero");
        }
    }
}
