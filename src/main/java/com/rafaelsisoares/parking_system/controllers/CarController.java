package com.rafaelsisoares.parking_system.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rafaelsisoares.parking_system.controllers.dto.CarDto;
import com.rafaelsisoares.parking_system.services.CarService;

@RestController
@RequestMapping(value = "/cars")
public class CarController {
  private CarService carService;

  @Autowired
  public CarController(CarService carService) {
    this.carService = carService;
  }

  @GetMapping
  public List<CarDto> getAllCars() {
    return carService.getAll().stream().map(CarDto::fromEntity).toList();
  }


}
