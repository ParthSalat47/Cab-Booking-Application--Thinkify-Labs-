package com.thinkifylabs.cabbookingapp.exceptionHandling;

import org.springframework.http.HttpStatus;

public class CustomException extends Exception{
    
    private final HttpStatus status;
    private final String errorMessage;

    //Constructors
    public CustomException(HttpStatus status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }

    //Getters
    public HttpStatus getStatus() {
        return status;
    }
    public String getErrorMessage() {
        return errorMessage;
    }

    
}
