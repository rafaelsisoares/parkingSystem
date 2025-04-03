package com.rafaelsisoares.parking_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rafaelsisoares.parking_system.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
