package com.rafaelsisoares.parking_system.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rafaelsisoares.parking_system.entities.Car;
import com.rafaelsisoares.parking_system.entities.Person;
import com.rafaelsisoares.parking_system.repositories.CarRepository;
import com.rafaelsisoares.parking_system.services.exceptions.CarNotFoundException;
import com.rafaelsisoares.parking_system.services.exceptions.PersonNotFoundException;

@Service
public class CarService {
  private CarRepository carRepository;
  private PersonService personService;

  @Autowired
  public CarService(CarRepository carRepository, PersonService personService) {
    this.carRepository = carRepository;
    this.personService = personService;
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

  public Car updateCar(Long id, Car car) throws CarNotFoundException {
    Car carFromDb = getById(id);

    carFromDb.setBrand(car.getBrand());
    carFromDb.setModel(car.getModel());
    carFromDb.setPlate(car.getPlate());

    return carRepository.save(carFromDb);
  }

  public Car removeCar(Long id) throws CarNotFoundException {
    Car car = getById(id);

    carRepository.delete(car);

    return car;
  }

  public Car setPerson(Long carId, Long personId)
      throws CarNotFoundException, PersonNotFoundException {
    Car car = getById(carId);
    Person person = personService.getById(personId);

    car.setPerson(person);

    return carRepository.save(car);
  }
}
