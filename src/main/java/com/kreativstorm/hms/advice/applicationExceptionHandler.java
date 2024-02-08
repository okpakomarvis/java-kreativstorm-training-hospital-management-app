package com.kreativstorm.hms.advice;

import com.kreativstorm.hms.exception.ClientErrorResponse;
import com.kreativstorm.hms.exception.ClientException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.kreativstorm.hms.utill.Constant.FAILED;

@RestControllerAdvice
public class applicationExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ClientException.class)
    public ResponseEntity<ClientErrorResponse> handleException(ClientException exc){

        //create a Client Error response
        ClientErrorResponse error = new ClientErrorResponse ();

        error.setStatus(FAILED);
        error.setMessage(exc.getMessage());
        error.setTimestamps(System.currentTimeMillis());

        //return entity

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // add exception handler to catch any exceptions

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public ResponseEntity<ClientErrorResponse> handleAnyException(Exception exc){
        //create  Error response
        ClientErrorResponse error = new ClientErrorResponse ();

        error.setStatus(FAILED);
        error.setMessage(exc.getMessage());
        error.setTimestamps(System.currentTimeMillis());
        //return entity

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}

