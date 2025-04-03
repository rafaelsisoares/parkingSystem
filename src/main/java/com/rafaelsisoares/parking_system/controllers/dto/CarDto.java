package com.rafaelsisoares.parking_system.controllers.dto;

import com.rafaelsisoares.parking_system.entities.Car;

public record CarDto(Long id, String brand, String model, String plate) {
  public static CarDto fromEntity(Car car) {
    return new CarDto(car.getId(), car.getBrand(), car.getModel(), car.getPlate());
  }
}
