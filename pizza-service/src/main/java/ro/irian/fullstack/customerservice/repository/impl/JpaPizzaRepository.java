package ro.irian.fullstack.customerservice.repository.impl;

import org.springframework.stereotype.Repository;
import ro.irian.fullstack.customerservice.domain.BaseEntity;
import ro.irian.fullstack.customerservice.domain.Pizza;
import ro.irian.fullstack.customerservice.domain.ReviewVO;
import ro.irian.fullstack.customerservice.repository.PizzaRepository;

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
        if (entity.isTransient()) {
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

    @SuppressWarnings("unchecked")
    @Override
    public List<ReviewVO> getReviewVOsByAuthor(String author) {
        return em.createQuery("select new ro.irian.fullstack.pizza.domain.ReviewVO(p.name, " +
                "r.stars," +
                "r.body," +
                "r.author) " +
                "from Pizza p " +
                "join p.reviews r "
                + "where r.author = :author")
                .setParameter("author", author)
                .getResultList();
    }
}
