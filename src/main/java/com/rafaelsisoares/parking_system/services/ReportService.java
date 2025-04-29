package com.rafaelsisoares.parking_system.services;

import com.rafaelsisoares.parking_system.entities.Report;
import com.rafaelsisoares.parking_system.repositories.ReportRepository;
import com.rafaelsisoares.parking_system.services.exceptions.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    private final ReportRepository reportRepository;

    @Autowired
    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public List<Report> findAll() {
        return reportRepository.findAll();
    }

    public List<Report> findByName(String name) {
        return reportRepository.findByName(name);
    }

    public List<Report> findByPlate(String plate) {
        return reportRepository.findByPlate(plate);
    }

    public Report create(Report report) {
        return reportRepository.save(report);
    }
}
