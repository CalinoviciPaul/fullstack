package ro.irian.fullstack.customerservice;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Services/JPA repo/Persistence configuration
 */
@Configuration
@EnableJpaRepositories("ro.irian.fullstack.customerservice.repository")
@ComponentScan(basePackages = {"ro.irian.fullstack.customerservice.service",
        "ro.irian.fullstack.customerservice.repository"})
@ImportResource("classpath:/META-INF/pizza-persistence.spring.xml")
public class CustomerServiceConfig {
}

