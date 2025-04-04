package com.rafaelsisoares.parking_system.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.rafaelsisoares.parking_system.controllers.dto.CarCreationDto;
import com.rafaelsisoares.parking_system.controllers.dto.CarDto;
import com.rafaelsisoares.parking_system.services.CarService;
import com.rafaelsisoares.parking_system.services.exceptions.CarNotFoundException;
import com.rafaelsisoares.parking_system.services.exceptions.PersonNotFoundException;

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

  @GetMapping("/{id}")
  public CarDto getCarById(@PathVariable Long id) throws CarNotFoundException {
    return CarDto.fromEntity(carService.getById(id));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CarDto createCar(@RequestBody CarCreationDto car) {
    return CarDto.fromEntity(carService.createCar(car.toEntity()));
  }

  @PutMapping("/{id}")
  public CarDto updateCar(@PathVariable Long id, @RequestBody CarCreationDto car)
      throws CarNotFoundException {
    return CarDto.fromEntity(carService.updateCar(id, car.toEntity()));
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public CarDto removeCar(@PathVariable Long id) throws CarNotFoundException {
    return CarDto.fromEntity(carService.removeCar(id));
  }

  @PutMapping("/{carId}/person/{personId}")
  public CarDto setPerson(@PathVariable Long carId, @PathVariable Long personId)
      throws CarNotFoundException, PersonNotFoundException {
    return CarDto.fromEntity(carService.setPerson(carId, personId));
  }
}
