package com.myapplication.myapplication.exception;

public class Studentnotfoundexception extends RuntimeException{

    public Studentnotfoundexception(String message) {
        super(message);
    }

    public Studentnotfoundexception(String message, Throwable cause) {
        super(message, cause);
    }
}
