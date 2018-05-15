package ro.irian.fullstack.pizza.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.irian.fullstack.pizza.domain.Customer;
import ro.irian.fullstack.pizza.repository.CustomerCrudRepository;
import ro.irian.fullstack.pizza.service.CustomerService;
import ro.irian.fullstack.pizza.service.exception.CustomerNotFoundException;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerCrudRepository customerCrudRepository;

    @Override
    public Customer findCustomerById(String id) {
        Optional<Customer> customerOptional = customerCrudRepository.findById(id);

        if(customerOptional.isPresent()){
            return customerOptional.get();
        } else {
            throw new CustomerNotFoundException(id);
        }
    }

    @Override
    public Iterable<Customer> findAllCustomers() {
        return customerCrudRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Customer customer) {
        customerCrudRepository.save(customer);
    }
}
