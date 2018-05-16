package ro.irian.fullstack.customerservice.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ro.irian.fullstack.customerservice.domain.Order;


/**
 * @author Georgia Papp
 */
public interface OrderCrudRepository extends PagingAndSortingRepository<Order, String> {

}
