package com.yourname.exchange;

public class InvalidOrderException extends Exception {
    public InvalidOrderException(String message) {
        super(message);
    }
}
