package uz.anorbank.applications;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ApplicationsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationsApplication.class, args);
    }
}
