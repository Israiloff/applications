package uz.anorbank.applications.service;

import reactor.core.publisher.Mono;
import uz.anorbank.applications.dto.ApplicationDto;


public interface ApplicationService {
    Mono<ApplicationDto> getById(Long id);
}
