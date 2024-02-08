package com.myapplication.myapplication.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class Responsehandler {
public static ResponseEntity<Object> res(String message, HttpStatus httpStatus, Object object){

    Map<String, Object> responsehandle = new HashMap<>();
    responsehandle.put("message",message);
    responsehandle.put("HttpStatus",httpStatus);
    responsehandle.put("Output",object);

    return new ResponseEntity<>(responsehandle,httpStatus);
}
}
