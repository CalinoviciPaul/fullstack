package ro.irian.fullstack.customerservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.irian.fullstack.customerservice.domain.Order;
import ro.irian.fullstack.customerservice.domain.Pizza;
import ro.irian.fullstack.customerservice.domain.PizzaOrder;
import ro.irian.fullstack.customerservice.repository.OrderCrudRepository;
import ro.irian.fullstack.customerservice.repository.PizzaCrudRepository;
import ro.irian.fullstack.customerservice.service.OrderService;
import ro.irian.fullstack.customerservice.service.exception.OrderNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderCrudRepository orderCrudRepository;

    @Autowired
    private PizzaCrudRepository pizzaCrudRepository;

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
    public Order save(Order order) {
        //calling save and having a detached entity reference would fail.
        //Therefore reloading the Pizza entity as an work around for this demo - a more proper solution would be to use entity manager merge
        List<PizzaOrder> pizzasOrderManaged = new ArrayList<>();

        for (PizzaOrder pizzaOrder : order.getPizzaOrders()) {
            Pizza managedPizza = pizzaCrudRepository.findById(pizzaOrder.getPizza().get_id())
                    .get();
            PizzaOrder pizzaOrderForPersist = new PizzaOrder(pizzaOrder.getQuantity(), managedPizza);
            pizzasOrderManaged.add(pizzaOrderForPersist);
        }

        Order orderWithManagedPizza = new Order(order.getCustomerId(), pizzasOrderManaged);

        return orderCrudRepository.save(orderWithManagedPizza);
    }
}
