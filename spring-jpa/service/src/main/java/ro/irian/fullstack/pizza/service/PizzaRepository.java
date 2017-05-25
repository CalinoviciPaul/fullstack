package ro.irian.fullstack.pizza.service;

import ro.irian.fullstack.pizza.domain.BaseEntity;
import ro.irian.fullstack.pizza.domain.Pizza;

import java.util.List;

/**
 * @author Cristi Toth
 */
public interface PizzaRepository {

    List<Pizza> findAllPizzas();

    Pizza findPizzaById(String id);

    void save(BaseEntity entity);

    List<Pizza> findPizzasByIngredient(String ingredient);

}
