package com.rafaelsisoares.parking_system.controllers.dto;

import com.rafaelsisoares.parking_system.entities.Person;

public record PersonCreationDto(String name, String email, String phone) {
  public Person toEntity() {
    return new Person(name, email, phone);
  }
}
