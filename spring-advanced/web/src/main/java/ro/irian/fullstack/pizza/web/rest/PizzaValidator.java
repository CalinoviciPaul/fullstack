package ro.irian.fullstack.pizza.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ro.irian.fullstack.pizza.domain.Pizza;
import ro.irian.fullstack.pizza.service.PizzaService;

/**
 * @author Georgia Papp
 */
@Component
public class PizzaValidator implements Validator {

    @Autowired
    private PizzaService pizzaService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Pizza.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Pizza pizzaToValidate = (Pizza) o;

        if (pizzaService.findPizzaByName(pizzaToValidate.getName()) != null) {
            errors.rejectValue("name", "Pizza name must be unique");
        }
    }
}
