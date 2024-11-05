package com.siemens.resilience4jdemo.exceptions;

public class IgnoreException extends RuntimeException{
    public IgnoreException(String message) {
        super(message);
    }
}
