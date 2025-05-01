package com.rafaelsisoares.parking_system.services.exceptions;

public class UnauthorizedPlateException extends UnauthorizedException {
    public UnauthorizedPlateException() {
        super("Placa não cadastrada!");
    }
}
