package com.vehix.platform.monitoring.interfaces;

import com.vehix.platform.monitoring.domain.model.queries.GetAllFailuresByErrorTypeQuery;
import com.vehix.platform.monitoring.domain.services.FailureQueryService;
import com.vehix.platform.monitoring.interfaces.resource.FailureResource;
import com.vehix.platform.monitoring.interfaces.transform.FailureResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/errors/{errorType}/failures", produces = "application/json")
@Tag(name = "Errors", description = "Endpoints related to ODB Errors and their Failures")
public class ErrorFailuresController {

    private final FailureQueryService failureQueryService;

    public ErrorFailuresController(FailureQueryService failureQueryService) {
        this.failureQueryService = failureQueryService;
    }

    @GetMapping
    @Operation(
            summary = "Get Failures by Error Type",
            description = "Returns a list of failures associated with a specific error type"
    )
    @ApiResponse(responseCode = "200", description = "List of failures")
    public ResponseEntity<List<FailureResource>> getFailuresByErrorType(@PathVariable String errorType) {
        var query = new GetAllFailuresByErrorTypeQuery(errorType);
        var failures = failureQueryService.handle(query);
        var resources = failures.stream()
                .map(FailureResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(resources);
    }
}