package ro.irian.fullstack.pizza.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.irian.fullstack.pizza.domain.Pizza;
import ro.irian.fullstack.pizza.domain.Review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * REST service for pizzas.
 *
 * @author Cristi Toth
 */


@RestController()
@RequestMapping("/rest/pizzas")
public class PizzaController {


    @GetMapping()
    public List<Pizza> getAllPizzas() {
       return PizzaController.pizzas;
    }

    @GetMapping("/{id}")
    public Pizza findPizza(@PathVariable("id")String pizzaId) {
        return PizzaController.pizzaMap.get(pizzaId);
    }



    private static List<Pizza> pizzas;
    private static Map<String, Pizza> pizzaMap;

    static {
        pizzas = new ArrayList<>(3);
        pizzaMap = new HashMap<>(5);


        Pizza pizza;

        pizza = new Pizza("pizza1",
                          "4 STAGIONI",
                          27.5,
                          550,
                          "images/quattro.png",
                          "sos rosii, mozzarella, ciuperci, salam, sunca presata, oregano, anghinare");
        pizza.addReview(new Review(5, "I love this pizza!", "joe@example.org", 100000000L));
        pizza.addReview(new Review(4, "It's great!", "miha@example.org", 100000000L));
        pizzas.add(pizza);

        pizza = new Pizza("pizza2",
                          "PEPPERONI",
                          25D,
                          450,
                          "images/pepperoni.png",
                          "sos rosii, mozzarella, salam picant, oregano");
        pizza.addReview(new Review(5, "It's the best pizza!", "marius@irian.ro", 110000000L));
        pizza.addReview(new Review(1, "It's awful!", "cristi@irian.ro", 130000000L));
        pizzas.add(pizza);

        pizza = new Pizza("pizza3",
                          "MARGARITA",
                          21.5,
                          500,
                          "images/margarita.png",
                          "sos rosii, mozzarella, oregano");
        pizza.addReview(new Review(2, "It's too boring!", "cristi@irian.ro", 140000000L));
        pizzas.add(pizza);

        pizzas.stream().forEach(p -> pizzaMap.put(p.get_id(), p));
    }

}
