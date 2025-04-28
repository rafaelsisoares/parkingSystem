package com.rafaelsisoares.parking_system.services.exceptions;

public class UnauthorizedException extends Exception {
    public UnauthorizedException(String message) {
        super(message);
    }
}
