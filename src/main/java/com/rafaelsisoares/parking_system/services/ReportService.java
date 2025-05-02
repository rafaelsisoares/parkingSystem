package com.rafaelsisoares.parking_system.services;

import com.rafaelsisoares.parking_system.entities.Report;
import com.rafaelsisoares.parking_system.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
    private final ReportRepository reportRepository;

    @Autowired
    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public List<Report> findAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Report> reportPage =  reportRepository.findAll(pageable);
        return reportPage.toList();
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
