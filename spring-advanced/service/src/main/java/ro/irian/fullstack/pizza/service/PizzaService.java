package ro.irian.fullstack.pizza.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import ro.irian.fullstack.pizza.domain.Pizza;
import ro.irian.fullstack.pizza.domain.Review;

import java.util.List;

/**
 * @author Cristi Toth
 */
public interface PizzaService {
    List<Pizza> getAllPizzas();

    Pizza findPizza(String pizzaId);

    String addPizzaReview(String pizzaId, Review review);

    @Scheduled(cron = "0 * * * * ?")
    void notifyNewReviews();

    @Cacheable
    List<String> getIngredients();

    void createTestdata();
}
