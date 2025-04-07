package com.rafaelsisoares.parking_system.seeders;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.rafaelsisoares.parking_system.entities.Car;
import com.rafaelsisoares.parking_system.repositories.CarRepository;

@Component
public class CarSeeder implements CommandLineRunner {
  private CarRepository carRepository;

  public CarSeeder(CarRepository carRepository) {
    this.carRepository = carRepository;
  }

  @Override
  public void run(String... args) {
    System.out.println(args);
    seedCars();
  }

  private void seedCars() {
    List<Car> cars = new ArrayList<>();

    cars.add(new Car("Chevrolet", "Opala", "FDE0I83"));
    cars.add(new Car("Fiat", "Uno", "GHJ9343"));
    cars.add(new Car("Volkswagen", "Jetta", "AAA1234"));
    cars.add(new Car("Toyota", "Corolla", "DEZ1H17"));
    cars.add(new Car("Ford", "Bronco", "DCX4B77"));

    carRepository.saveAll(cars);
  }
}
