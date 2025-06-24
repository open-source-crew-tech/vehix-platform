package com.vehix.platform.monitoring.interfaces;

import com.vehix.platform.monitoring.domain.model.commands.CreateOdbErrorCommand;
import com.vehix.platform.monitoring.domain.model.entities.OdbError;
import com.vehix.platform.monitoring.domain.model.queries.GetAllOdbErrorsQuery;
import com.vehix.platform.monitoring.domain.model.queries.GetOdbErrorByIdQuery;
import com.vehix.platform.monitoring.domain.services.OdbErrorCommandService;
import com.vehix.platform.monitoring.domain.services.OdbErrorQueryService;
import com.vehix.platform.monitoring.interfaces.resource.CreateOdbErrorResource;
import com.vehix.platform.monitoring.interfaces.resource.OdbErrorResource;
import com.vehix.platform.monitoring.interfaces.transform.CreateOdbErrorCommandFromResourceAssembler;
import com.vehix.platform.monitoring.interfaces.transform.OdbErrorResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

/**
 * Controller for managing OdbErrors.
 */
@RestController
@RequestMapping(value = "/api/v1/odberrors", produces = APPLICATION_JSON_VALUE)
@Tag(name = "OdbErrors", description = "Available Odb Errors Endpoints")
public class OdbErrorsController {

    private final OdbErrorCommandService odbErrorCommandService;
    private final OdbErrorQueryService odbErrorQueryService;

    public OdbErrorsController(OdbErrorCommandService odbErrorCommandService,
                               OdbErrorQueryService odbErrorQueryService) {
        this.odbErrorCommandService = odbErrorCommandService;
        this.odbErrorQueryService = odbErrorQueryService;
    }

    /**
     * Returns an OdbError by its ID.
     */
    @GetMapping("/{odbErrorId}")
    @Operation(
            summary = "Get Odb Error by Id",
            description = "Returns an Odb Error by its unique identifier."
    )
    @ApiResponse(responseCode = "200", description = "Odb Error found")
    @ApiResponse(responseCode = "404", description = "Odb Error not found")
    public ResponseEntity<OdbErrorResource> getOdbErrorById(@PathVariable int odbErrorId) {
        var query = new GetOdbErrorByIdQuery(odbErrorId);
        var odbError = odbErrorQueryService.handle(query);
        return odbError
                .map(entity -> ResponseEntity.ok(OdbErrorResourceFromEntityAssembler.toResourceFromEntity(entity)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Returns a list of all OdbErrors.
     */
    @GetMapping
    @Operation(
            summary = "Get All Odb Errors",
            description = "Returns a list of all available Odb Errors."
    )
    @ApiResponse(responseCode = "200", description = "List of Odb Errors")
    public ResponseEntity<List<OdbErrorResource>> getAllOdbErrors() {
        var odbErrors = odbErrorQueryService.handle(new GetAllOdbErrorsQuery());
        var resources = odbErrors.stream()
                .map(OdbErrorResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(resources);
    }

    /**
     * Creates a new OdbError.
     */
    @PostMapping
    @Operation(
            summary = "Create a New Odb Error",
            description = "Creates a new Odb Error and returns the created Odb Error resource."
    )
    @ApiResponse(responseCode = "201", description = "Odb Error created successfully")
    @ApiResponse(responseCode = "400", description = "Odb Error could not be created")
    public ResponseEntity<OdbErrorResource> createOdbError(@RequestBody CreateOdbErrorResource resource) {
        CreateOdbErrorCommand command = CreateOdbErrorCommandFromResourceAssembler.toCommandFromResource(resource);
        Optional<OdbError> odbError = odbErrorCommandService.handle(command);
        if (odbError.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var odbErrorResource = OdbErrorResourceFromEntityAssembler.toResourceFromEntity(odbError.orElse(null));
        return ResponseEntity
                .created(null)
                .body(odbErrorResource);
    }
}