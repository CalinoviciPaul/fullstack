package ro.irian.fullstack.pizza.web.rest;

/**
 * @author Georgia Papp
 */
public class ValidationError {

    private String fieldName;
    private String errorMessage;

    public ValidationError(String fieldName,
                           String errorMessage) {
        this.fieldName = fieldName;
        this.errorMessage = errorMessage;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
