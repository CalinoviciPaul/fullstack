package ro.irian.fullstack.pizza.service.exception;

/**
 * @author Cristi Toth
 */
public class OrderNotFoundException extends ServiceException {

    private String id;

    public OrderNotFoundException(String id) {
        super("Order '" + id + "' not found!");
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
