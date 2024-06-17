package com.rafaelsisoares.parking_system.services.exceptions;

public class CarNotFoundException extends NotFoundException {

  public CarNotFoundException() {
    super("Carro não encontrado");
  }

}
