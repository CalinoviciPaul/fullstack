package ro.irian.fullstack.pizza.service;

import org.springframework.stereotype.Repository;
import ro.irian.fullstack.pizza.domain.BaseEntity;
import ro.irian.fullstack.pizza.domain.Pizza;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Cristi Toth
 */
@Repository
public class JpaPizzaRepository implements PizzaRepository {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Pizza> findAllPizzas() {
        return em.createQuery("select p from Pizza p").getResultList();
    }

    @Override
    public Pizza findPizzaById(String id) {
        return em.find(Pizza.class, id);
    }

    @Override
    public void save(BaseEntity entity) {
        if (!entity.isTransient()) {
            em.persist(entity);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Pizza> findPizzasByIngredient(String ingredient) {
        return em.createQuery("select p from Pizza p"
                              + " where p.ingredients like :ingredient")
                 .setParameter("ingredient", "%" + ingredient + "%")
                 .getResultList();
    }
}
