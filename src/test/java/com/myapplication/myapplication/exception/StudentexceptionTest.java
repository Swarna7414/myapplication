package com.myapplication.myapplication.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

class StudentexceptionTest {

    private String message= "gotcha error";

    private Throwable throwable= new RuntimeException("Got error");

    HttpStatus httpStatus = HttpStatus.NOT_FOUND;


    @Test
    public void testexception(){

        Studentexception studentexception= new Studentexception(message,throwable,httpStatus);

        studentexception.getMessage();
        studentexception.getThrowable();
        studentexception.getHttpStatus();

    }
}