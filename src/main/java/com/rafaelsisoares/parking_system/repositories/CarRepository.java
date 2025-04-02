package com.rafaelsisoares.parking_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rafaelsisoares.parking_system.entities.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

}
