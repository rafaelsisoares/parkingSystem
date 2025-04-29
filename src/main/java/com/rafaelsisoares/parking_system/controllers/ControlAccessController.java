package com.rafaelsisoares.parking_system.controllers;

import com.rafaelsisoares.parking_system.entities.ControlAccess;
import com.rafaelsisoares.parking_system.services.ControlAccessService;
import com.rafaelsisoares.parking_system.services.exceptions.DoubleAccessException;
import com.rafaelsisoares.parking_system.services.exceptions.UnauthorizedPlateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/access")
public class ControlAccessController {
    private final ControlAccessService controlAccessService;

    @Autowired
    public ControlAccessController(ControlAccessService controlAccessService) {
        this.controlAccessService = controlAccessService;
    }

    @PutMapping("/entrance")
    public ResponseEntity<String> entrance(@RequestParam("plate") String plate) throws DoubleAccessException, UnauthorizedPlateException {
        return ResponseEntity.status(HttpStatus.OK).body("Bem vindo(a) " + controlAccessService.entrance(plate).getName());
    }

    @PutMapping("/exit")
    public ResponseEntity<String> exit(@RequestParam("plate") String plate) throws DoubleAccessException, UnauthorizedPlateException {
        return ResponseEntity.status(HttpStatus.OK).body("Até logo " + controlAccessService.exit(plate).getName());
    }
}
