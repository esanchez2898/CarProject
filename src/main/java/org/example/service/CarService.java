package org.example.service;

import org.example.model.Car;
import org.example.repository.CarRepository;

import java.util.List;

public class CarService {

    private CarRepository carRepository;
    private int nextId = 4; // Ya tienes 3 carros creados

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // READ ALL
    public List<Car> getAllCars() {
        return carRepository.getAllCars();
    }

    // READ BY ID
    public Car getCarById(int id) {
        return carRepository.getCarById(id);
    }

    // READ BY YEAR
    public List<Car> getCarByYear(int year) {

        return carRepository.getAllCars()
                .stream()
                .filter(car -> car.getYear() == year)
                .toList();
    }

    // CREATE
    public void createCar(String model, int year, double price) {

        Car car = new Car(nextId, model, year, price);
        nextId++;

        carRepository.addNewCar(car);
    }

    // UPDATE
    public boolean updateCar(int id, String model, int year, double price) {
        return carRepository.updateCar(id, model, year, price);
    }

    // DELETE
    public boolean deleteCar(int id) {
        return carRepository.deleteCar(id);
    }

}