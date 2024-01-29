package com.ericvizu.backendpc.services.exceptions;

public class InvalidNumberException extends RuntimeException {
    public InvalidNumberException(String msg) {
        super(msg);
    }
}
