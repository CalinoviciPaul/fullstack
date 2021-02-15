package ro.irian.fullstack.pizza.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.irian.fullstack.pizza.domain.Pizza;
import ro.irian.fullstack.pizza.domain.Review;
import ro.irian.fullstack.pizza.service.exception.PizzaNotFoundException;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Service for Pizzas.
 *
 * @author Cristi Toth
 */

@Service
public class PizzaServiceImpl implements PizzaService {

    private static final Logger LOG = LoggerFactory.getLogger(PizzaServiceImpl.class);


    //TODO: inject repository
    @Autowired
    PizzaRepository pizzaRepository;

    @PostConstruct
    public void init() {
        LOG.info("Service initialized");
    }

    @Override
    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAllPizzas();
    }

    @Override
    public Pizza findPizza(String pizzaId) {
        Pizza pizza = null; //TODO;

        if (pizza == null) {
            throw new PizzaNotFoundException(pizzaId);
        }

        return pizza;
    }

    @Override
    @Transactional
    public void createTestdata() {


        Pizza pizza;

        pizza = new Pizza("pizza1",
                          "4 STAGIONI",
                          27.5,
                          550,
                          "images/quattro.png",
                          "sos rosii, mozzarella, ciuperci, salam, sunca presata, oregano, anghinare");
        pizza.addReview(new Review(5, "I love this pizza!", "joe@example.org", 100000000L));
        pizza.addReview(new Review(4, "It's great!", "miha@example.org", 100000000L));

//      TODO  save(pizza);

        pizza = new Pizza("pizza2",
                          "PEPPERONI",
                          25D,
                          450,
                          "images/pepperoni.png",
                          "sos rosii, mozzarella, salam picant, oregano");
        pizza.addReview(new Review(5, "It's the best pizza!", "marius@irian.ro", 110000000L));
        pizza.addReview(new Review(1, "It's awful!", "cristi@irian.ro", 130000000L));

//      TODO  save(pizza);

        pizza = new Pizza("pizza3",
                          "MARGARITA",
                          21.5,
                          500,
                          "images/margarita.png",
                          "sos rosii, mozzarella, oregano");
        pizza.addReview(new Review(2, "It's too boring!", "cristi@irian.ro", 140000000L));
//      TODO  save(pizza);

        LOG.info("Testdata initialized");
    }

}
