package ro.irian.fullstack.pizza.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import ro.irian.fullstack.pizza.service.exception.PizzaNotFoundException;

/**
 * Exception handler for Spring rest controllers annotated with {@see RestController}.
 */
//TODO: annotate advice, specify which beans to intercept
@ControllerAdvice()
public class RestExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(RestExceptionHandler.class);

    //TODO: handle PizzaNotFoundException  - HttpStatus ???


    @ExceptionHandler(PizzaNotFoundException.class)
    public ResponseEntity<ExceptionEntity> handlePizzaNotFoundException(RuntimeException e) {
        LOG.debug("Error during REST call", e);
        return new ResponseEntity<>(ExceptionEntity.from(e), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionEntity> handleRuntimeException(RuntimeException e) {
        LOG.error("Error during REST call", e);
        return new ResponseEntity<>(ExceptionEntity.from(e), HttpStatus.BAD_REQUEST);
    }

}
