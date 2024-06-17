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

  public Person createPerson(Person person) {
    return personRepository.save(person);
  }

  public Person updatePerson(Long id, Person person) throws PersonNotFoundException {
    Person personFromDb = getPersonById(id);

    personFromDb.setName(person.getName());
    personFromDb.setEmail(person.getEmail());
    personFromDb.setPhone(person.getPhone());

    return personRepository.save(personFromDb);
  }

  public Person removePerson(Long id) throws PersonNotFoundException {
    Person person = getPersonById(id);

    personRepository.delete(person);

    return person;
  }
}
