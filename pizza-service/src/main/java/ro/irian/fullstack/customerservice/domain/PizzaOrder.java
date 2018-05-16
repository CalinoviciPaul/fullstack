package ro.irian.fullstack.customerservice.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class PizzaOrder extends BaseEntity{

    private Integer quantity;

    @ManyToOne
    private Pizza pizza;

    public PizzaOrder() {
    }

    public PizzaOrder(Integer quantity, Pizza pizza) {
        this.set_id(this.createUUID());
        this.quantity = quantity;
        this.pizza = pizza;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Pizza getPizza() {
        return pizza;
    }

}
