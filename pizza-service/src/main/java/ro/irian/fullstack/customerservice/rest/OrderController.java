package ro.irian.fullstack.customerservice.rest;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ro.irian.fullstack.customerservice.domain.Customer;
import ro.irian.fullstack.customerservice.domain.Order;
import ro.irian.fullstack.customerservice.service.OrderService;
import ro.irian.fullstack.customerservice.service.WebCustomerService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * REST service for orders...
 *
 * @author Cristi Toth
 */

@RestController
@RequestMapping("/rest/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private WebCustomerService webCustomerService;


    @RequestMapping(method = {RequestMethod.GET})
    public Iterable<Order> getAllOrders() {
        return orderService.findAllOrders();
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public Order findOrder(@PathVariable("id") String orderId) {
        return orderService.findOrderById(orderId);
    }

    @RequestMapping(method = {RequestMethod.POST})
    public ResponseEntity<?> saveOrder(@RequestBody Order order) throws URISyntaxException {
        //TODO
        // implement WebCustomerServiceImpl with a RestTemplate
        // implement getCustomerById and saveCustomer methods in WebCustomerServiceImpl
        // check if Order has an existing Customer (getById returns something other than null)
        // if Order doesn't have an existing Customer - save new Customer then set in Order

       Order persistedOrder  = orderService.save(order);

        return ResponseEntity.created(
                new URI("/rest/orders/" + persistedOrder.get_id()))
                .body(persistedOrder);
    }


}
