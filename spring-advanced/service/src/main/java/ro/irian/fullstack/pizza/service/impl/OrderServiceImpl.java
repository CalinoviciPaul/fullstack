package ro.irian.fullstack.pizza.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.irian.fullstack.pizza.domain.Order;
import ro.irian.fullstack.pizza.repository.OrderCrudRepository;
import ro.irian.fullstack.pizza.service.OrderService;
import ro.irian.fullstack.pizza.service.exception.OrderNotFoundException;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderCrudRepository orderCrudRepository;

    @Override
    public Iterable<Order> findAllOrders() {
        return orderCrudRepository.findAll();
    }

    @Override
    public Order findOrderById(String id) {
        Optional<Order> orderOptional = orderCrudRepository.findById(id);

        if(orderOptional.isPresent()){
            return orderOptional.get();
        } else {
            throw new OrderNotFoundException(id);
        }
    }

    @Override
    @Transactional
    public void save(Order order) {
        orderCrudRepository.save(order);
    }
}
