package com.vehix.platform.monitoring.interfaces;


import com.vehix.platform.monitoring.domain.model.commands.CreateFailureCommand;
import com.vehix.platform.monitoring.domain.model.queries.GetAllFailuresQuery;
import com.vehix.platform.monitoring.domain.model.queries.GetFailureByIdQuery;
import com.vehix.platform.monitoring.domain.services.FailureCommandService;
import com.vehix.platform.monitoring.domain.services.FailureQueryService;
import com.vehix.platform.monitoring.interfaces.resource.CreateFailureResource;
import com.vehix.platform.monitoring.interfaces.resource.FailureResource;
import com.vehix.platform.monitoring.interfaces.transform.CreateFailureCommandFromResourceAssembler;
import com.vehix.platform.monitoring.interfaces.transform.FailureResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for managing Failure entities.
 */
@RestController
@RequestMapping(value = "/api/v1/failures", produces = "application/json")
@Tag(name = "Failures", description = "Available Failure Endpoints")
public class FailuresController {

    private final FailureCommandService failureCommandService;
    private final FailureQueryService failureQueryService;

    public FailuresController(FailureCommandService failureCommandService, FailureQueryService failureQueryService) {
        this.failureCommandService = failureCommandService;
        this.failureQueryService = failureQueryService;
    }

    /**
     * Get a Failure by its ID.
     */
    @GetMapping("/{failureId}")
    @Operation(
            summary = "Get Failure by Id",
            description = "Returns a failure by its unique identifier"
    )
    @ApiResponse(responseCode = "200", description = "Failure found")
    @ApiResponse(responseCode = "404", description = "Failure not found")
    public ResponseEntity<FailureResource> getFailureById(@PathVariable Integer failureId) {
        var query = new GetFailureByIdQuery(failureId);
        var failure = failureQueryService.handle(query);
        if (failure.isEmpty()) return ResponseEntity.notFound().build();
        var resource = FailureResourceFromEntityAssembler.toResourceFromEntity(failure.get());
        return ResponseEntity.ok(resource);
    }

    /**
     * Get all Failures.
     */
    @GetMapping
    @Operation(
            summary = "Get All Failures",
            description = "Returns a list of all available failures"
    )
    @ApiResponse(responseCode = "200", description = "List of failures")
    public ResponseEntity<List<FailureResource>> getAllFailures() {
        var failures = failureQueryService.handle(new GetAllFailuresQuery());
        var resources = failures.stream()
                .map(FailureResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(resources);
    }

    /**
     * Create a new Failure.
     */
    @PostMapping
    @Operation(
            summary = "Create a New Failure",
            description = "Creates a new Failure and returns the created resource"
    )
    @ApiResponse(responseCode = "201", description = "Failure created successfully")
    @ApiResponse(responseCode = "400", description = "Failure could not be created")
    public ResponseEntity<FailureResource> createFailure(@RequestBody CreateFailureResource resource) {
        CreateFailureCommand command = CreateFailureCommandFromResourceAssembler.toCommandFromResource(resource);
        var result = failureCommandService.handle(command);
        if (result.isEmpty()) return ResponseEntity.badRequest().build();
        var created = FailureResourceFromEntityAssembler.toResourceFromEntity(result.get());
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
