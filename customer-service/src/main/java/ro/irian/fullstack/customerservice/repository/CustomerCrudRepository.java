package ro.irian.fullstack.customerservice.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ro.irian.fullstack.customerservice.domain.Customer;

/**
 * @author Georgia Papp
 */
public interface CustomerCrudRepository extends PagingAndSortingRepository<Customer, String> {

}
