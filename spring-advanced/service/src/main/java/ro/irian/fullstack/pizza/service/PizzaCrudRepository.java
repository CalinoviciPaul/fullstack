package ro.irian.fullstack.pizza.service;

import org.springframework.data.repository.PagingAndSortingRepository;
import ro.irian.fullstack.pizza.domain.Pizza;

import java.util.List;

/**
 * @author Georgia Papp
 */
public interface PizzaCrudRepository extends PagingAndSortingRepository<Pizza, String> {

    Pizza findOneByName(String name);

}
