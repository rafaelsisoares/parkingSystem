package com.rafaelsisoares.parking_system.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rafaelsisoares.parking_system.entities.Person;
import com.rafaelsisoares.parking_system.repositories.PersonRepository;
import com.rafaelsisoares.parking_system.services.exceptions.PersonNotFoundException;

@Service
public class PersonService {
  private PersonRepository personRepository;

  @Autowired
  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  public List<Person> getAllPersons() {
    return personRepository.findAll();
  }

  public Person getPersonById(Long id) throws PersonNotFoundException {
    return personRepository.findById(id).orElseThrow(PersonNotFoundException::new);
  }
}
