package uz.anorbank.applications.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import uz.anorbank.applications.dto.ApplicationDto;
import uz.anorbank.applications.service.ApplicationService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/application")
public class ApplicationController {

    private final ApplicationService applicationService;

    @Operation(summary = "Get application by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the application",
                    content = {@Content(mediaType = MediaType.APPLICATION_STREAM_JSON_VALUE,
                            schema = @Schema(implementation = ApplicationDto.class))})
    })
    @GetMapping(path = "/get/{id}", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Mono<ApplicationDto> getById(@PathVariable Long id) {
        log.info("rest request to getById for id : {}", id);
        return applicationService.getById(id);
    }
}
