package org.example.controller;

import org.example.model.Car;
import org.example.service.CarService;

import java.util.List;

public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    // READ ALL
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    // READ BY ID
    public Car getCarById(int id) {
        return carService.getCarById(id);
    }

    // READ BY YEAR
    public List<Car> getCarByYear(int year) {
        return carService.getCarByYear(year);
    }

    // CREATE
    public void createCar(String model, int year, double price) {
        carService.createCar(model, year, price);
    }

    // UPDATE
    public boolean updateCar(int id, String model, int year, double price) {
        return carService.updateCar(id, model, year, price);
    }

    // DELETE
    public boolean deleteCar(int id) {
        return carService.deleteCar(id);
    }

}