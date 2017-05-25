package ro.irian.fullstack.pizza.service.exception;

/**
 * Exception class for business exceptions in services.
 *
 * @author Cristi Toth
 */
public class ServiceException extends RuntimeException {

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
