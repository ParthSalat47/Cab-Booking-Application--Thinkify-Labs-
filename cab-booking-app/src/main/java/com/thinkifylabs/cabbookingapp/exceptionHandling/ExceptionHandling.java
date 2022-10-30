package com.thinkifylabs.cabbookingapp.exceptionHandling;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandling extends ResponseEntityExceptionHandler{

    /*
     * This is thrown when the method argument data types don't match.
     * It encompasses NumberFormatException.
     * Returns 400 BAD_REQUEST
     */
    @ExceptionHandler(value 
    = {MethodArgumentTypeMismatchException.class})
    public ResponseEntity<Object> handleNumberFormatException(MethodArgumentTypeMismatchException exceptionObject, WebRequest request)
    {
        return handleExceptionInternal(exceptionObject, exceptionObject.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    /*
     * This is thrown when at least one of the method parameters are missing.
     * Returns 400 BAD_REQUEST
     */
    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
			MissingServletRequestParameterException exceptionObject, HttpHeaders headers, HttpStatus status, WebRequest request) {

		return handleExceptionInternal(exceptionObject, exceptionObject.getMessage(), headers, status, request);
	}

    /*
     * Throws an exception with a custom message and HTTP status code.
     */
    @ExceptionHandler(value = {CustomException.class})
    public ResponseEntity<Object> handleCustomException(CustomException exceptionObject, WebRequest request)
    {
        return handleExceptionInternal(exceptionObject, exceptionObject.getErrorMessage(), new HttpHeaders(), exceptionObject.getStatus(), request);
    }





}
