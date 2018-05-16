package ro.irian.fullstack.customerservice.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity{

    @Transient
    private Customer customer;

    private String customerId;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<PizzaOrder> pizzaOrders;

    public Order() {
    }

    public Order(String customerId, List<PizzaOrder> pizzaOrders) {
        this.set_id(this.createUUID());
        this.customerId = customerId;
        this.pizzaOrders = pizzaOrders;
    }

    public Order(Customer customer, List<PizzaOrder> pizzaOrders) {
        this.customer = customer;
        this.pizzaOrders = pizzaOrders;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<PizzaOrder> getPizzaOrders() {
        return pizzaOrders;
    }
}
