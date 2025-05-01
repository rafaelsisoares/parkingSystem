package com.rafaelsisoares.parking_system.services.exceptions;

public class DataNotFoundException extends NotFoundException {
    public DataNotFoundException() {
        super("Dados não encontrados");
    }
}
