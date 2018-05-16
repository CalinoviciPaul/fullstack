package ro.irian.fullstack.customerservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.irian.fullstack.customerservice.domain.Pizza;
import ro.irian.fullstack.customerservice.domain.ReviewVO;
import ro.irian.fullstack.customerservice.service.PizzaService;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * REST service for pizzas..
 *
 * @author Cristi Toth
 */

@RestController
@RequestMapping("/rest/pizzas")
public class PizzaController {


    @Autowired
    private PizzaService pizzaService;


    @RequestMapping(method = {RequestMethod.GET})
    public Iterable<Pizza> getAllPizzas() {
        return pizzaService.getAllPizzas();
    }

    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public Pizza findPizza(@PathVariable("id") String pizzaId) {
        return pizzaService.findPizza(pizzaId);
    }

    @RequestMapping(method = {RequestMethod.GET}, value = "/page")
    public Page<Pizza> getPagedPizzas(Pageable pageable) {
        return pizzaService.getPagedPizzas(pageable);
    }

    @RequestMapping(method = {RequestMethod.GET}, value = "/reviews/auhor/{author}")
    public Iterable<ReviewVO> getReviewsByAuthor(@PathVariable("author")String author) {
        return pizzaService.getReviewsForAuthor(author);
    }

    @RequestMapping(method = {RequestMethod.POST})
    public ResponseEntity<?> savePizza(@RequestBody Pizza pizza) throws URISyntaxException {
        if (pizzaService.findPizzaByName(pizza.getName()) == null) {
            pizzaService.save(pizza);
            return ResponseEntity.created(
                    new URI("/rest/pizzas/" + pizza.get_id()))
                    .build();
        }
        else {
            return ResponseEntity.badRequest().body(
                    new ValidationError(
                            "name",
                            "Pizza name must be unique"));
        }
    }
}
