package ro.irian.fullstack.pizza.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Spring configuration for service module.
 *
 * @author Cristi Toth
 */
@Configuration
@ComponentScan(basePackages = "ro.irian.fullstack.pizza.service")
public class PizzaServiceConfig {

}
