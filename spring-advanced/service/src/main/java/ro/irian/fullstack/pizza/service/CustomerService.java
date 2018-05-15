package ro.irian.fullstack.pizza.service;

import ro.irian.fullstack.pizza.domain.Customer;

public interface CustomerService {

    Customer findCustomerById(String id);

    Iterable<Customer> findAllCustomers();

    void save(Customer customer);

}
