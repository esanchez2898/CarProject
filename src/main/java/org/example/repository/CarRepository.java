package org.example.repository;

import org.example.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {

    private List<Car> cars;

    public CarRepository() {

        cars = new ArrayList<>();

        Car c1 = new Car(1, "nissan", 2020, 10000);
        Car c2 = new Car(2, "tesla", 2025, 50000);
        Car c3 = new Car(3, "ford", 2019, 10500);

        cars.add(c1);
        cars.add(c2);
        cars.add(c3);
    }

    // READ ALL
    public List<Car> getAllCars() {
        return cars;
    }

    // READ BY ID
    public Car getCarById(int id) {

        for (Car car : cars) {
            if (car.getId() == id) {
                return car;
            }
        }

        return null;
    }

    // CREATE
    public void addNewCar(Car car) {
        cars.add(car);
        System.out.println("The car was added.");
    }

    // UPDATE
    public boolean updateCar(int id, String model, int year, double price) {

        Car car = getCarById(id);

        if (car != null) {

            car.setModel(model);
            car.setYear(year);
            car.setPrice(price);

            return true;
        }
        // if dont exist... add a new car

        return false;
    }

    // DELETE
    public boolean deleteCar(int id) {

        Car car = getCarById(id);

        if (car != null) {
            cars.remove(car);
            return true;
        }

        return false;
    }

}