package ro.irian.fullstack.pizza.service;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.persistence.Entity;

/**
 * Spring configuration for service module.
 *
 * @author Cristi Toth
 */
@Configuration
@ComponentScan(basePackages = "ro.irian.fullstack.pizza.service")
@EntityScan(basePackages = "ro.irian.fullstack.pizza.domain")
public class PizzaServiceConfig {

}
