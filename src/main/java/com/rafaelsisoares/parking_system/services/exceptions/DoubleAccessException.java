package com.rafaelsisoares.parking_system.services.exceptions;

public class DoubleAccessException extends UnauthorizedException {
    public DoubleAccessException() {
        super("Acesso duplo! Limpe o status da credencial");
    }
}
