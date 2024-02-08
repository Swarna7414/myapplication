package com.myapplication.myapplication.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class StudentexceptionhandlerTest {

    @Test
    void exceptionhandler() {

        // Create an instance of Studentnotfoundexception with a message
        Studentnotfoundexception studentnotfoundexception = new Studentnotfoundexception("Student not found");

        // Create an instance of Studentexceptionhandler
        Studentexceptionhandler studentexceptionhandler = new Studentexceptionhandler();

        // Call the exceptionhandler method with the Studentnotfoundexception
        ResponseEntity<Object> responseEntity = studentexceptionhandler.exceptionhandler(studentnotfoundexception);

        // Assert that the response entity has the expected status code (OK)
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}