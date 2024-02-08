package com.myapplication.myapplication.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentnotfoundexceptionTest {

    @Test
    void testexception(){
        Studentnotfoundexception studentnotfoundexception = new Studentnotfoundexception("student details not found");

        Studentnotfoundexception studentnotfoundexception1= new Studentnotfoundexception("Studentdetailsnotfound",new RuntimeException("see this"));
    }

}