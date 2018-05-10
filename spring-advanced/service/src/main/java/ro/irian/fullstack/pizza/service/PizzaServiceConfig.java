package ro.irian.fullstack.pizza.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Spring configuration for service module.
 *
 * @author Cristi Toth
 */
@Configuration
@EnableJpaRepositories("ro.irian.fullstack.pizza.service")
@ComponentScan(basePackages = "ro.irian.fullstack.pizza.service")
@ImportResource("classpath:/META-INF/pizza-persistence.spring.xml")
public class PizzaServiceConfig {

}
