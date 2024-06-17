package com.rafaelsisoares.parking_system.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rafaelsisoares.parking_system.entities.Car;
import com.rafaelsisoares.parking_system.repositories.CarRepository;
import com.rafaelsisoares.parking_system.services.exceptions.CarNotFoundException;

@Service
public class CarService {
  private CarRepository carRepository;

  @Autowired
  public CarService(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  public List<Car> getAll() {
    return carRepository.findAll();
  }

  public Car getById(Long id) throws CarNotFoundException {
    return carRepository.findById(id).orElseThrow(CarNotFoundException::new);
  }

  public Car createCar(Car car) {
    return carRepository.save(car);
  }
}
