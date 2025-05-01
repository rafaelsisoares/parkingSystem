package com.rafaelsisoares.parking_system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rafaelsisoares.parking_system.entities.Car;
import org.springframework.data.jpa.repository.Query;

public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("SELECT c FROM Car c WHERE c.plate=:plate")
    Car findByPlate(String plate);
}
