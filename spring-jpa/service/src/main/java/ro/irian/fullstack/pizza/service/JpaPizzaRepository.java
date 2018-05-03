package ro.irian.fullstack.pizza.service;

import org.springframework.stereotype.Repository;
import ro.irian.fullstack.pizza.domain.BaseEntity;
import ro.irian.fullstack.pizza.domain.Pizza;

import java.util.List;

/**
 * @author Cristi Toth
 */
@Repository
public class JpaPizzaRepository implements PizzaRepository {

    //TODO: inject EntityManager

    @SuppressWarnings("unchecked")
    @Override
    public List<Pizza> findAllPizzas() {
        //TODO
    }

    @Override
    public Pizza findPizzaById(String id) {
        return em.find(Pizza.class, id);
    }

    @Override
    public void save(BaseEntity entity) {
        if (entity.isTransient()) {
            em.persist(entity);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Pizza> findPizzasByIngredient(String ingredient) {
        //TODO
    }
}
