package com.vehix.platform.monitoring.interfaces;

import com.vehix.platform.monitoring.domain.model.commands.CreateBadPracticeCommand;
import com.vehix.platform.monitoring.domain.model.entities.BadPractice;
import com.vehix.platform.monitoring.domain.model.queries.GetAllBadPracticesQuery;
import com.vehix.platform.monitoring.domain.model.queries.GetBadPracticeByIdQuery;
import com.vehix.platform.monitoring.domain.services.BadPracticeCommandService;
import com.vehix.platform.monitoring.domain.services.BadPracticeQueryService;
import com.vehix.platform.monitoring.interfaces.resource.BadPracticeResource;
import com.vehix.platform.monitoring.interfaces.resource.CreateBadPracticeResource;
import com.vehix.platform.monitoring.interfaces.transform.BadPracticeResourceFromEntityAssembler;
import com.vehix.platform.monitoring.interfaces.transform.CreateBadPracticeCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/bad-practices", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Bad Practices", description = "Available Bad Practices Endpoints")
public class BadPracticesController {

    private final BadPracticeCommandService badPracticeCommandService;
    private final BadPracticeQueryService badPracticeQueryService;

    public BadPracticesController(BadPracticeCommandService badPracticeCommandService,
                                  BadPracticeQueryService badPracticeQueryService) {
        this.badPracticeCommandService = badPracticeCommandService;
        this.badPracticeQueryService = badPracticeQueryService;
    }

    @GetMapping("/{badPracticeId}")
    @Operation(summary = "Get Bad Practice by Id", description = "Returns a Bad Practice by its unique identifier")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bad Practice found"),
            @ApiResponse(responseCode = "404", description = "Bad Practice not found")
    })
    public ResponseEntity<BadPracticeResource> getBadPracticeById(@PathVariable Long badPracticeId) {
        var query = new GetBadPracticeByIdQuery(Math.toIntExact(badPracticeId));
        var badPractice = badPracticeQueryService.handle(query);
        if (badPractice.isEmpty()) return ResponseEntity.notFound().build();
        var resource = BadPracticeResourceFromEntityAssembler.toResourceFromEntity(badPractice.get());
        return ResponseEntity.ok(resource);
    }

    @GetMapping
    @Operation(summary = "Get All Bad Practices", description = "Returns a list of all available Bad Practices")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of Bad Practices")
    })
    public ResponseEntity<List<BadPracticeResource>> getAllBadPractices() {
        var result = badPracticeQueryService.handle(new GetAllBadPracticesQuery());
        var resources = result.stream()
                .map(BadPracticeResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resources);
    }

    @PostMapping
    @Operation(summary = "Create a New Bad Practice", description = "Creates a new Bad Practice and returns the resource")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Bad Practice created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Practice could not be created")
    })
    public ResponseEntity<BadPracticeResource> createBadPractice(@RequestBody CreateBadPracticeResource resource) {
        CreateBadPracticeCommand command = CreateBadPracticeCommandFromResourceAssembler.toCommandFromResource(resource);
        BadPractice badPractice = badPracticeCommandService.handle(command);
        if (badPractice.isEmpty()) return ResponseEntity.badRequest().build();
        var createdResource = BadPracticeResourceFromEntityAssembler.toResourceFromEntity(badPractice);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdResource);
    }
}