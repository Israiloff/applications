package uz.anorbank.applications.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import uz.anorbank.applications.domain.Application;
import uz.anorbank.applications.service.ApplicationService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/application")
public class ApplicationController {

    private final ApplicationService applicationService;

    @GetMapping(path = "/get/{id}")
    public Mono<Application> getById(@PathVariable Long id) {
        log.info("rest request to getById for id : {}", id);
        return applicationService.getById(id);
    }
}
