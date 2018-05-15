package ro.irian.fullstack.pizza.service;

import ro.irian.fullstack.pizza.domain.Order;

import java.util.List;

public interface OrderService {

    Iterable<Order> findAllOrders();

    Order findOrderById(String id);

    void save(Order order);

}
