package com.rafaelsisoares.parking_system.controllers;

import com.rafaelsisoares.parking_system.controllers.dto.ReportDto;
import com.rafaelsisoares.parking_system.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<ReportDto> findAll(
            @RequestParam(required = false, defaultValue = "0") int pageNumber,
            @RequestParam(required = false, defaultValue = "5") int pageSize
    ) {
        return reportService.findAll(pageNumber, pageSize).stream().map(ReportDto::fromEntity).toList();
    }

    @GetMapping("/name")
    public List<ReportDto> findByName(@RequestBody String name) {
        return reportService.findByName(name).stream().map(ReportDto::fromEntity).toList();
    }

    @GetMapping("/plate")
    public List<ReportDto> findByPlate(@RequestBody String plate) {
        return reportService.findByPlate(plate).stream().map(ReportDto::fromEntity).toList();
    }
}
