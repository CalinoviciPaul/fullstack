package ro.irian.fullstack.customerservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.irian.fullstack.customerservice.domain.Customer;
import ro.irian.fullstack.customerservice.repository.CustomerCrudRepository;
import ro.irian.fullstack.customerservice.service.CustomerService;
import ro.irian.fullstack.customerservice.service.exception.CustomerNotFoundException;

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

    @Override
    public void createTestdata() {
        Customer customerIon = new Customer("customerId1", "Ion Popescu",
                "ion.popescu@irian.ro",
                "0712322112",
                "Str Dej nr 3 ap 10, Timisoara");
        customerCrudRepository.save(customerIon);

        Customer customerJohn = new Customer("customerId2", "John Doe",
                "John.Doe@irian.ro",
                "0711122112",
                "Str Paris nr 3 ap 12, Timisoara");
        customerCrudRepository.save(customerJohn);
    }
}
