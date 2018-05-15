package ro.irian.fullstack.pizza;

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
@EnableJpaRepositories("ro.irian.fullstack.pizza.repository")
@ComponentScan(basePackages = {"ro.irian.fullstack.pizza.service",
                                "ro.irian.fullstack.pizza.repository"})
@ImportResource("classpath:/META-INF/pizza-persistence.spring.xml")
public class PizzaServiceConfig {

}
