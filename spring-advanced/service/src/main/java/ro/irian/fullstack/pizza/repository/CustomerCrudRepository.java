package ro.irian.fullstack.pizza.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ro.irian.fullstack.pizza.domain.Customer;
import ro.irian.fullstack.pizza.domain.Pizza;

/**
 * @author Georgia Papp
 */
public interface CustomerCrudRepository extends PagingAndSortingRepository<Customer, String> {

}
