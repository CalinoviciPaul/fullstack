package ro.irian.fullstack.customerservice.service;

import ro.irian.fullstack.customerservice.domain.Customer;

public interface CustomerService {

    Customer findCustomerById(String id);

    Iterable<Customer> findAllCustomers();

    void save(Customer customer);

    void createTestdata();

}
