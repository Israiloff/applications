package uz.anorbank.applications.service;

import reactor.core.publisher.Mono;
import uz.anorbank.applications.domain.Application;


public interface ApplicationService {
    Mono<Application> getById(Long id);
}
