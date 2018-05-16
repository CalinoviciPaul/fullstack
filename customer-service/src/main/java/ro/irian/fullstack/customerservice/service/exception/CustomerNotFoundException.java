package ro.irian.fullstack.customerservice.service.exception;

/**
 * @author Cristi Toth
 */
public class CustomerNotFoundException extends ServiceException {

    private String id;

    public CustomerNotFoundException(String id) {
        super("Customer '" + id + "' not found!");
        this.id = id;
    }

    public String getId() {
        return id;
    }

}
