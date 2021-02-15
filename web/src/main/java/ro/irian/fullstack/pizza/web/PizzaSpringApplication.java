package ro.irian.fullstack.pizza.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import ro.irian.fullstack.pizza.service.PizzaServiceConfig;

/**
 * Spring boot main configuration
 *
 * @author Cristi Toth
 */
//TODO replace with detailed annotations
@SpringBootApplication
@Import(PizzaServiceConfig.class)
public class PizzaSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(PizzaSpringApplication.class, args);
    }

}
