package com.lucasmurilo.newhelpdesk.resources.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandarError{

    private List<FieldMessage> errors = new ArrayList<>();


    public ValidationError(Integer status, String mensagem, Long timeStamp) {
        super(status, mensagem, timeStamp);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String fielName, String message){
        this.errors.add(new FieldMessage(fielName, message));
    }
}
