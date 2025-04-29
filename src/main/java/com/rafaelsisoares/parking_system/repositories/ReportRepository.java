package com.rafaelsisoares.parking_system.repositories;

import com.rafaelsisoares.parking_system.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
