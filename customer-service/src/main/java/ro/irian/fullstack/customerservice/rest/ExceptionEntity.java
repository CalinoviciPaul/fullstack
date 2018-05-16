package ro.irian.fullstack.customerservice.rest;


import ro.irian.fullstack.customerservice.service.exception.ServiceException;

public class ExceptionEntity {
    private final String exceptionType;
    private final String exceptionMessage;

    public static ExceptionEntity from(RuntimeException exception) {
        return new ExceptionEntity(exception.getClass().getName(), exception.getMessage());
    }

    public static ExceptionEntity from(ServiceException exception) {
        return new ExceptionEntity(exception.getClass().getName(),
                                   exception.getMessage());
    }

    protected ExceptionEntity(String exceptionType,
                            String exceptionMessage) {
        this.exceptionType = exceptionType;
        this.exceptionMessage = exceptionMessage;

    }

    public String getExceptionType() {
        return exceptionType;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }


    @Override
    public String toString() {
        return "ExceptionEntity{" +
               "exceptionType='" + exceptionType + '\'' +
               '}';
    }
}
