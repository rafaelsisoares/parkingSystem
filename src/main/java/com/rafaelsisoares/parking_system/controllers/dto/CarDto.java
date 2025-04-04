package com.rafaelsisoares.parking_system.controllers.dto;

import com.rafaelsisoares.parking_system.entities.Car;

public record CarDto(Long id, String brand, String model, String plate, PersonDto person) {
  public static CarDto fromEntity(Car car) {
    PersonDto personDto = car.getPerson() != null ? PersonDto.fromEntity(car.getPerson()) : null;

    return new CarDto(car.getId(), car.getBrand(), car.getModel(), car.getPlate(), personDto);
  }
}
