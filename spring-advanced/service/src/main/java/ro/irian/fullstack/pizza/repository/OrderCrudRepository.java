package ro.irian.fullstack.pizza.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ro.irian.fullstack.pizza.domain.Customer;
import ro.irian.fullstack.pizza.domain.Order;

/**
 * @author Georgia Papp
 */
public interface OrderCrudRepository extends PagingAndSortingRepository<Order, String> {

}
