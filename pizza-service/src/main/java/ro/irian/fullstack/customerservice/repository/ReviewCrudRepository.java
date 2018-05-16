package ro.irian.fullstack.customerservice.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ro.irian.fullstack.customerservice.domain.Review;

import java.util.List;

/**
 * @author Georgia Papp
 */
public interface ReviewCrudRepository extends PagingAndSortingRepository<Review, String> {
    List<Review> findAllByAuthorIgnoreCase(String authorName);
}
