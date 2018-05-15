package ro.irian.fullstack.pizza.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

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
