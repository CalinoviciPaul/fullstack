package ro.irian.fullstack.customerservice.service;

import ro.irian.fullstack.customerservice.domain.Order;

public interface OrderService {

    Iterable<Order> findAllOrders();

    Order findOrderById(String id);

    Order save(Order order);

}
