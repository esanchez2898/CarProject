package org.example;

import org.example.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int ID = 1;

    public static int idCounter() {
        return ID++;
    }

    public static void main(String[] args) {



        Car c1 = new Car(idCounter(), "nissan", 2020, 10000); //0xy64783264932
        Car c2 = new Car(idCounter(), "tesla", 2025, 50000); //0x8272189109880
        Car c3 = new Car(idCounter(), "ford", 2019, 10500);
        List<Car> cars = new ArrayList<>();
        cars.add(c1);
        cars.add(c2);
        cars.add(c3);

        Scanner sc = new Scanner(System.in);
        int option;

        do {

            System.out.println("select an option: (1) Get All Cars.   (2) Get Car by Id   (3) Create New Car   (6) Finish");
            option = sc.nextInt();
            sc.nextLine(); // limpiar buffer


            switch (option) {

                case 1:
                    Main.getAllCars(cars);
                    break;

                case 2:
                    System.out.println("id car: ");
                    int idCar = sc.nextInt();
                    System.out.println(Main.getCarById(cars, idCar));
                    break;

                case 3:
                    System.out.println("\nWrite the model: ");
                    String model = sc.nextLine();
                    System.out.println("\nWrite the year: ");
                    int year = sc.nextInt();
                    sc.nextLine();
                    System.out.println("\nWrite the price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    addNewCar(cars, model, year, price);
                    break;

                case 4:

                    break;

                case 6:
                    System.out.println("bye");
                    break;

                default:
                    System.out.println("invalid");
                    break;
            }
        } while(option != 6);

    }

    public static void getAllCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public static Car getCarById(List<Car> cars, int id) {
        for( Car car : cars ) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }

    public static void addNewCar(List<Car> cars, String model, int year, double price) {
        cars.add(new Car(idCounter(), model, year, price));
        System.out.println("The car " + model + " was added");
    }

}