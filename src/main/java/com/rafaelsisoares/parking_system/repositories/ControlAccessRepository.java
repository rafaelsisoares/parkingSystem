package com.rafaelsisoares.parking_system.repositories;

import com.rafaelsisoares.parking_system.entities.ControlAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ControlAccessRepository extends JpaRepository<ControlAccess, Long> {

    // Query personalizada para encontrar um registro na tabela de acordo com um parametro diferente da chave primaria.
    @Query("SELECT r FROM ControlAccess r WHERE r.plate =:plate")
    ControlAccess findByPlate(String plate);
}
