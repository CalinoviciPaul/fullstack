package ro.irian.fullstack.pizza.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity{

    @ManyToOne
    private Customer customer;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<PizzaOrder> pizzaOrders;

    public Order() {
    }

    public Order(Customer customer, List<PizzaOrder> pizzaOrders) {
        this.set_id(this.createUUID());
        this.customer = customer;
        this.pizzaOrders = pizzaOrders;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<PizzaOrder> getPizzaOrders() {
        return pizzaOrders;
    }
}
