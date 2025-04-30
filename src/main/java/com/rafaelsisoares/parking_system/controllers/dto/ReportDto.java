package com.rafaelsisoares.parking_system.controllers.dto;

import com.rafaelsisoares.parking_system.entities.Report;

public record ReportDto(Long id, String name, String plate, String position, String date) {
    public static ReportDto fromEntity(Report report) {
        return new ReportDto(report.getId(), report.getName(), report.getPlate(), report.getPosition(), report.getDate());
    }
}
