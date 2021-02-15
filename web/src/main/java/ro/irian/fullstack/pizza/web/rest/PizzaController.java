package ro.irian.fullstack.pizza.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ro.irian.fullstack.pizza.domain.Pizza;
import ro.irian.fullstack.pizza.service.PizzaService;

import java.util.List;

/**
 * REST service for pizzas.
 *
 * @author Cristi Toth
 */
@RestController
@RequestMapping("/rest/pizzas")
public class PizzaController {


    //TODO: inject PizzaService
    @Autowired
    PizzaService pizzaService;

    //TODO: call the service

    @RequestMapping(method = {RequestMethod.GET})
    public List<Pizza> getAllPizzas() {
        return pizzaService.getAllPizzas();
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public Pizza findPizza(@PathVariable("id") String pizzaId) {
        return pizzaService.findPizza(pizzaId);
    }


}
