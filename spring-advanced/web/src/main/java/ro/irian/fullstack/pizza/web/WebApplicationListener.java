package ro.irian.fullstack.pizza.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import ro.irian.fullstack.pizza.service.PizzaService;

@Component
@Order(10)
public class WebApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOG = LoggerFactory.getLogger(WebApplicationListener.class);

    private Environment environment;
    private ApplicationContext applicationContext;

    private PizzaService pizzaService;

    @Autowired
    public WebApplicationListener(Environment environment,
                                  ApplicationContext applicationContext,
                                  PizzaService pizzaService) {
        this.environment = environment;
        this.applicationContext = applicationContext;
        this.pizzaService = pizzaService;

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        pizzaService.createTestdata();
        LOG.debug("Pizza application started in env:" + environment);
    }

}
