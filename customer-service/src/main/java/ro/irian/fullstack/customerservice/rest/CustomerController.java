package ro.irian.fullstack.customerservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.irian.fullstack.customerservice.domain.Customer;
import ro.irian.fullstack.customerservice.service.CustomerService;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * REST service for orders..
 *
 * @author Cristi Toth
 */

@RestController
@RequestMapping("/rest/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = {RequestMethod.GET})
    public Iterable<Customer> getAllCustomers() {
        return customerService.findAllCustomers();
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public Customer findCustomer(@PathVariable("id") String customerId) {
        return customerService.findCustomerById(customerId);
    }

    @RequestMapping(method = {RequestMethod.POST})
    public ResponseEntity<?> saveCustomer(@RequestBody Customer customer) throws URISyntaxException {
        customerService.save(customer);

        return ResponseEntity.created(
                new URI("/rest/customers/" + customer.get_id()))
                .build();
    }
}
