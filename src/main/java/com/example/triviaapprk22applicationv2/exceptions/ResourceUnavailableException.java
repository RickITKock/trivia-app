package com.example.triviaapprk22applicationv2.exceptions;

public class ResourceUnavailableException extends RuntimeException {
    public ResourceUnavailableException() {
        super();
    }

    public ResourceUnavailableException(String message) {
        super(message);
    }
}
