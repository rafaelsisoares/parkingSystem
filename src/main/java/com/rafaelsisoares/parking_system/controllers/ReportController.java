package com.rafaelsisoares.parking_system.controllers;

import com.rafaelsisoares.parking_system.controllers.dto.ReportDto;
import com.rafaelsisoares.parking_system.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/reports")
public class ReportController {
    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public List<ReportDto> findAll() {
        return reportService.findAll().stream().map(ReportDto::fromEntity).toList();
    }
}
