package com.rafaelsisoares.parking_system.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.rafaelsisoares.parking_system.controllers.dto.PersonCreationDto;
import com.rafaelsisoares.parking_system.controllers.dto.PersonDto;
import com.rafaelsisoares.parking_system.services.PersonService;
import com.rafaelsisoares.parking_system.services.exceptions.PersonNotFoundException;

@RestController
@RequestMapping(value = "/persons")
public class PersonController {
  private PersonService personService;

  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  @GetMapping
  public List<PersonDto> getAllPersons() {
    return personService.getAll().stream().map(PersonDto::fromEntity).toList();
  }

  @GetMapping("/{id}")
  public PersonDto getPersonById(@PathVariable Long id) throws PersonNotFoundException {
    return PersonDto.fromEntity(personService.getById(id));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PersonDto createPerson(@RequestBody PersonCreationDto person) {
    return PersonDto.fromEntity(personService.createPerson(person.toEntity()));
  }
}
