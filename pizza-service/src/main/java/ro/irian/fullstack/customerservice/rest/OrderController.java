package ro.irian.fullstack.customerservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.irian.fullstack.customerservice.domain.Order;
import ro.irian.fullstack.customerservice.service.OrderService;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * REST service for orders..
 *
 * @author Cristi Toth
 */

@RestController
@RequestMapping("/rest/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;


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
//        if(order.getCustomer().get_id() == null){
//            customerService.save(order.getCustomer());
//        }
//
       orderService.save(order);

        return ResponseEntity.created(
                new URI("/rest/orders/" + order.get_id()))
                .build();
    }
}
