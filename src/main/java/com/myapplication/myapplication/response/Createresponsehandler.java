package com.myapplication.myapplication.response;

import com.myapplication.myapplication.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class Createresponsehandler {

    public static ResponseEntity<Object> cres(String message, HttpStatus httpStatus,Student name){

        Map<String, Object> responsehandle = new HashMap<>();

        responsehandle.put("Message", "User created");
        responsehandle.put("Status", httpStatus);
        responsehandle.put("Name",name.getName());

        return new ResponseEntity<>(responsehandle,HttpStatus.CREATED);

    }
}
