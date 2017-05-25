package ro.irian.fullstack.pizza.service;

import ro.irian.fullstack.pizza.domain.Pizza;

import java.util.List;

/**
 * @author Cristi Toth
 */
public interface PizzaService {
    List<Pizza> getAllPizzas();

    Pizza findPizza(String pizzaId);
}
