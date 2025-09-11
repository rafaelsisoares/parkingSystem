package com.rafaelsisoares.parking_system.repositories;

import com.rafaelsisoares.parking_system.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {
    List<Report> findByName(String name);

    List<Report> findByPlate(String plate);
}
