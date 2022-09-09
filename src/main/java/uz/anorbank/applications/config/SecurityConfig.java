package uz.anorbank.applications.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Slf4j
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        log.debug("springSecurityFilterChain started");

        return http.csrf().disable()
                .authorizeExchange()
                .pathMatchers("/swagger-ui/**", "/management/**").permitAll()
                .pathMatchers("/api/**").authenticated()
                .and()
                .build();
    }
}
