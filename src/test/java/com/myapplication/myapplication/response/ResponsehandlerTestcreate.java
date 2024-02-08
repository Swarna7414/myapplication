package com.myapplication.myapplication.response;

import com.myapplication.myapplication.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class ResponsehandlerTestcreate {

    @Test
    void res() {

        String message="details created";
        HttpStatus httpStatus= HttpStatus.CREATED;
        Student student=new Student();

        ResponseEntity<Object> responseEntity = Createresponsehandler.cres(message,httpStatus,student);
    }
}