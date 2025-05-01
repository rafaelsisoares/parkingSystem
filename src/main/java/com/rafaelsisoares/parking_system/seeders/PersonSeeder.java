package com.rafaelsisoares.parking_system.seeders;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.rafaelsisoares.parking_system.entities.Person;
import com.rafaelsisoares.parking_system.repositories.PersonRepository;

@Component
public class PersonSeeder implements CommandLineRunner {
  private final PersonRepository personRepository;

  public PersonSeeder(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    seedPersons();
  }

  private void seedPersons() {
    List<Person> persons = new ArrayList<>();

    persons.add(new Person("Barack Obrahma", "b.obrahma@email.com", "21 988979862"));
    persons.add(new Person("Simone Tibet", "simone.t@email.com", "19 34583421"));
    persons.add(new Person("McDonald Trump", "mctrump@email.com", "51 956754785"));
    persons.add(new Person("Emmanuel Macarron", "e.macarron@email.com", "45 964562568"));
    persons.add(new Person("Silas Maracutaia", "silas.mara@email.com", "75 943563855"));

    personRepository.saveAll(persons);
  }
}
