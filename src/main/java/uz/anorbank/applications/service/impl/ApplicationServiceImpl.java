package uz.anorbank.applications.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import uz.anorbank.applications.dto.ApplicationDto;
import uz.anorbank.applications.error.EntityNotFoundException;
import uz.anorbank.applications.mapper.ApplicationMapper;
import uz.anorbank.applications.repository.ApplicationRepository;
import uz.anorbank.applications.service.ApplicationService;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final ApplicationMapper mapper;

    @Override
    public Mono<ApplicationDto> getById(Long id) {
        log.debug("getById started with id : {}", id);
        return applicationRepository
                .findById(id)
                .switchIfEmpty(Mono.error(new EntityNotFoundException(id)))
                .doOnNext(application -> log.debug("application got : {}", application))
                .map(mapper::toDto);
    }
}
