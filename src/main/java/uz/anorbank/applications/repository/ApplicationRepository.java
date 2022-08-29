package uz.anorbank.applications.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import uz.anorbank.applications.domain.Application;

public interface ApplicationRepository extends ReactiveCrudRepository<Application, Long> {
}
