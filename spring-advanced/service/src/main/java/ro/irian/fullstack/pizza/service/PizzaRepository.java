package ro.irian.fullstack.pizza.service;

import ro.irian.fullstack.pizza.domain.BaseEntity;
import ro.irian.fullstack.pizza.domain.Pizza;
import ro.irian.fullstack.pizza.domain.ReviewVO;

import java.util.Date;
import java.util.List;

/**
 * @author Cristi Toth
 */
public interface PizzaRepository {

    List<Pizza> findAllPizzas();

    Pizza findPizzaById(String id);

    void save(BaseEntity entity);

    List<Pizza> findPizzasByIngredient(String ingredient);

    List<ReviewVO> getReviewVOsByAuthor(String author);
}
