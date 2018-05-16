package ro.irian.fullstack.customerservice.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ro.irian.fullstack.customerservice.domain.Pizza;

/**
 * @author Georgia Papp
 */
public interface PizzaCrudRepository extends PagingAndSortingRepository<Pizza, String> {

    Pizza findOneByName(String name);

}
