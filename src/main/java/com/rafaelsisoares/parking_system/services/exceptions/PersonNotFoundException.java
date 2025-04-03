package com.rafaelsisoares.parking_system.services.exceptions;

public class PersonNotFoundException extends NotFoundException {

  public PersonNotFoundException() {
    super("Pessoa não encontrada");
  }

}
