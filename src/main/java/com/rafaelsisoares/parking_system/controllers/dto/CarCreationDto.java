package com.rafaelsisoares.parking_system.controllers.dto;

import com.rafaelsisoares.parking_system.entities.Car;

public record CarCreationDto(String brand, String model, String plate) {
  public Car toEntity() {

  }
}
