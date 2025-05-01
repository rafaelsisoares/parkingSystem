package com.rafaelsisoares.parking_system.services;

import com.rafaelsisoares.parking_system.entities.Car;
import com.rafaelsisoares.parking_system.entities.ControlAccess;
import com.rafaelsisoares.parking_system.entities.Report;
import com.rafaelsisoares.parking_system.repositories.ControlAccessRepository;
import com.rafaelsisoares.parking_system.services.exceptions.DoubleAccessException;
import com.rafaelsisoares.parking_system.services.exceptions.UnauthorizedPlateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ControlAccessService {
    private final ControlAccessRepository controlAccessRepository;
    private final CarService carService;
    private final ReportService reportService;

    @Autowired
    public ControlAccessService(ControlAccessRepository controlAccessRepository, CarService carService, ReportService reportService) {
        this.controlAccessRepository = controlAccessRepository;
        this.carService = carService;
        this.reportService = reportService;
    }

    private ControlAccess create(ControlAccess newAccess) {
        return controlAccessRepository.save(newAccess);
    }

    private List<ControlAccess> findAll() {
        return controlAccessRepository.findAll();
    }

    private ControlAccess findByPlate(String plate) {
        return controlAccessRepository.findByPlate(plate);
    }

    private void setReport(ControlAccess newAccess) {
        DateTimeFormatter brazilianPattern = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        Report report = new Report();
        report.setName(newAccess.getName());
        report.setPlate(newAccess.getPlate());
        report.setPosition(newAccess.getPosition() ? "IN" : "OUT");
        report.setDate(LocalDateTime.now().format(brazilianPattern));

        reportService.create(report);
    }

    private ControlAccess update(String plate, Boolean actualPosition) throws DoubleAccessException, UnauthorizedPlateException {
        ControlAccess result = findByPlate(plate);
        if(result == null) {
            Car car = carService.getByPlate(plate);
            if(car == null || car.getPerson() == null) {
                throw new UnauthorizedPlateException();
            }
            ControlAccess newAccess = new ControlAccess();
            newAccess.setPlate(car.getPlate());
            newAccess.setName(car.getPerson().getName());
            newAccess.setPosition(actualPosition);
            setReport(newAccess);
            return create(newAccess);
        }

        if(result.getPosition() == actualPosition) {
            throw new DoubleAccessException();
        }
        result.setPosition(actualPosition);
        setReport(result);
        return create(result);
    }

    public ControlAccess entrance(String plate) throws DoubleAccessException, UnauthorizedPlateException {
        return update(plate, true);
    }

    public ControlAccess exit(String plate) throws DoubleAccessException, UnauthorizedPlateException {
        return update(plate, false);
    }
}
