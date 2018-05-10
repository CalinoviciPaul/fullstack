package ro.irian.fullstack.pizza.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import ro.irian.fullstack.pizza.domain.Pizza;
import ro.irian.fullstack.pizza.domain.Review;

import java.util.List;

/**
 * @author Georgia Papp
 */
public interface ReviewCrudRepository extends PagingAndSortingRepository<Review, String> {
    List<Review> findAllByAuthorIgnoreCase(String authorName);
}
