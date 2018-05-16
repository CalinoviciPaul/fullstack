package ro.irian.fullstack.customerservice.repository;

import ro.irian.fullstack.customerservice.domain.BaseEntity;
import ro.irian.fullstack.customerservice.domain.Pizza;
import ro.irian.fullstack.customerservice.domain.ReviewVO;

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
