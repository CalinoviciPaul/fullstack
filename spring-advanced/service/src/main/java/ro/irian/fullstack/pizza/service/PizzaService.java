package ro.irian.fullstack.pizza.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import ro.irian.fullstack.pizza.domain.Pizza;
import ro.irian.fullstack.pizza.domain.Review;
import ro.irian.fullstack.pizza.domain.ReviewVO;

import java.util.List;

/**
 * @author Cristi Toth
 */
public interface PizzaService {
    void save(Pizza pizza);

    Iterable<Pizza> getAllPizzas();

    Page<Pizza> getPagedPizzas(Pageable pageable);

    Pizza findPizza(String pizzaId);

    Pizza findPizzaByName(String pizzaName);

    List<ReviewVO> getReviewsForAuthor(String authorName);

    void createTestdata();
}
