package com.myapplication.myapplication.response;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class ResponsehandlerTest {

    @Test
    void res() {
        String message= "Details created";
        HttpStatus httpStatus=HttpStatus.OK;
        Object object=new Object();

        ResponseEntity<Object> responseEntity= Responsehandler.res(message,httpStatus,object);
    }
}