package com.rafaelsisoares.parking_system.services.exceptions;

public class ExistingDataException extends ConflictException {

  public ExistingDataException() {
    super("Dados já existentes");
  }

}
