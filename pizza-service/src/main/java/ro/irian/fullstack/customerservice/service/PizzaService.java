package ro.irian.fullstack.customerservice.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ro.irian.fullstack.customerservice.domain.Pizza;
import ro.irian.fullstack.customerservice.domain.ReviewVO;

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
