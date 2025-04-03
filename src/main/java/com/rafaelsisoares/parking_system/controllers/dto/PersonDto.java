package com.rafaelsisoares.parking_system.controllers.dto;

import com.rafaelsisoares.parking_system.entities.Person;

public record PersonDto(Long id, String name, String email, String phone) {
  public static PersonDto fromEntity(Person person) {
    return new PersonDto(person.getId(), person.getName(), person.getEmail(), person.getPhone());
  }
}
