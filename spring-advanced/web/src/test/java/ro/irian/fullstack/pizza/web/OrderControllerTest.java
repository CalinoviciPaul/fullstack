package ro.irian.fullstack.pizza.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import ro.irian.fullstack.pizza.domain.Customer;
import ro.irian.fullstack.pizza.domain.Order;

import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class OrderControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void exampleTest() throws InterruptedException {
       ResponseEntity<Object> responseEntity =  restTemplate.getForEntity("/rest/orders", Object.class);
    }

}
