package ro.irian.fullstack.pizza.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Order(10)
public class WebApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    private Environment environment;
    private ApplicationContext applicationContext;

    @Autowired
    public WebApplicationListener(Environment environment,
                                  ApplicationContext applicationContext) {
        this.environment = environment;
        this.applicationContext = applicationContext;

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //TODO: add some debug logging
    }

}
