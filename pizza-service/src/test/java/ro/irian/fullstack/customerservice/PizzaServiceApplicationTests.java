package ro.irian.fullstack.customerservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import ro.irian.fullstack.customerservice.domain.Customer;
import ro.irian.fullstack.customerservice.domain.Order;
import ro.irian.fullstack.customerservice.domain.Pizza;
import ro.irian.fullstack.customerservice.domain.PizzaOrder;
import ro.irian.fullstack.customerservice.service.OrderService;
import ro.irian.fullstack.customerservice.service.PizzaService;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PizzaServiceApplicationTests {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private DiscoveryClient discoveryClient;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testOrderForExistingCustomer(){
		Pizza pizzaPeperoni = new Pizza("pizza2",
				"PEPPERONI",
				25D,
				450,
				"images/pepperoni.png",
				"sos rosii, mozzarella, salam picant, oregano");

		PizzaOrder pizzaOrder = new PizzaOrder(2, pizzaPeperoni);

		Order order = new Order("customerId1", Arrays.asList(pizzaOrder));

		List<ServiceInstance> instanceInfos =  discoveryClient.getInstances("pizza-service");
		ServiceInstance serviceInstance = instanceInfos.get(0);

		HttpEntity<Order> request = new HttpEntity<>(order);
		String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/rest/orders";

		Order createdOrder = restTemplate.postForObject(url,  request, Order.class);

		Order orderFromServer = restTemplate.getForObject(url + "/" + createdOrder.get_id(), Order.class);
		assertNotNull(orderFromServer);
	}

	@Test
	public void testOrderForNewCustomer(){
		Pizza pizzaPeperoni = new Pizza("pizza2",
				"PEPPERONI",
				25D,
				450,
				"images/pepperoni.png",
				"sos rosii, mozzarella, salam picant, oregano");

		PizzaOrder pizzaOrder = new PizzaOrder(2, pizzaPeperoni);

		Customer customerIon = new Customer("Ion Popescu2",
				"ion.popescu2@irian.ro",
				"07123221122",
				"Str Dej nr 5 ap 10, Timisoara");

		Order order = new Order(customerIon, Arrays.asList(pizzaOrder));

		List<ServiceInstance> pizzasServiceInstances =  discoveryClient.getInstances("pizza-service");
		ServiceInstance pizzaServiceInstance = pizzasServiceInstances.get(0);

		HttpEntity<Order> request = new HttpEntity<>(order);
		String url = "http://" + pizzaServiceInstance.getHost() + ":" + pizzaServiceInstance.getPort() + "/rest/orders";

		Order createdOrder = restTemplate.postForObject(url,  request, Order.class);

		//check order created
		Order orderFromServer = restTemplate.getForObject(url + "/" + createdOrder.get_id(), Order.class);
		assertNotNull(orderFromServer);

		//check customer created
		List<ServiceInstance> customerServiceInstances =  discoveryClient.getInstances("customer-service");
		ServiceInstance customerServiceInstance = customerServiceInstances.get(0);

		String customerUrl = "http://" + customerServiceInstance.getHost() + ":" + customerServiceInstance.getPort() + "/rest/customers/" + createdOrder.getCustomerId();

		Customer customer = restTemplate.getForObject(customerUrl, Customer.class);
		assertNotNull(customer);
	}



}
