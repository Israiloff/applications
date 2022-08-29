package uz.anorbank.applications.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import uz.anorbank.applications.domain.Application;
import uz.anorbank.applications.repository.ApplicationRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Override
    public Mono<Application> getById(Long id) {
        log.debug("getById started with id : {}", id);
        var app = applicationRepository.findById(id);
        log.debug("application got : {}", app);
        return app;
    }
}
