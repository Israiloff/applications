package uz.anorbank.applications.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.util.matcher.NegatedServerWebExchangeMatcher;
import org.springframework.security.web.server.util.matcher.OrServerWebExchangeMatcher;

import static org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers.pathMatchers;

@Slf4j
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        log.debug("springSecurityFilterChain started");

        return http.securityMatcher(new NegatedServerWebExchangeMatcher(new OrServerWebExchangeMatcher(
                        pathMatchers("/app/**", "/i18n/**", "/content/**", "/swagger-ui/**", "/test/**"),
                        pathMatchers(HttpMethod.OPTIONS, "/**"))))
                .csrf().disable()
                .authorizeExchange()
                .pathMatchers("/api/**").authenticated()
                .pathMatchers("/management/health").permitAll()
                .pathMatchers("/management/health/**").permitAll()
                .pathMatchers("/management/info").permitAll()
                .pathMatchers("/management/prometheus").permitAll()
                .and()
                .build();
    }
}
