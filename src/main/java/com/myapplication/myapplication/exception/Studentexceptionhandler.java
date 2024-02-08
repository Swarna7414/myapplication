package com.myapplication.myapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Studentexceptionhandler {

    @ExceptionHandler(Studentnotfoundexception.class)
    public ResponseEntity<Object> exceptionhandler(Studentnotfoundexception studentnotfoundexception){
        Studentexception studentexception= new Studentexception(
                studentnotfoundexception.getMessage(),
                studentnotfoundexception.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(studentexception,HttpStatus.OK);
    }

}
