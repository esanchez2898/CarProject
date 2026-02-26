package org.example;

import org.example.controller.CarController;
import org.example.repository.CarRepository;
import org.example.service.CarService;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CarRepository carRepository = new CarRepository();
        CarService carService = new CarService(carRepository);
        CarController carController = new CarController(carService);

        Scanner sc = new Scanner(System.in);
        int option;

        do {

            System.out.println("\n===== CAR SYSTEM =====");
            System.out.println("(1) Get All Cars");
            System.out.println("(2) Get Car by Id");
            System.out.println("(3) Create New Car");
            System.out.println("(4) Get Cars by Year");
            System.out.println("(5) Update Car");
            System.out.println("(6) Delete Car");
            System.out.println("(7) Exit");

            System.out.print("Select option: ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {

                // READ ALL
                case 1:
                    System.out.println("\nAll Cars:");
                    System.out.println(carController.getAllCars());
                    break;

                // READ BY ID
                case 2:
                    System.out.print("\nEnter car ID: ");
                    int idCar = sc.nextInt();
                    sc.nextLine();

                    System.out.println(carController.getCarById(idCar));
                    break;

                // CREATE
                case 3:
                    System.out.print("\nModel: ");
                    String model = sc.nextLine();

                    System.out.print("Year: ");
                    int year = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    sc.nextLine();

                    carController.createCar(model, year, price);

                    System.out.println("Car created successfully.");
                    break;

                // READ BY YEAR
                case 4:
                    System.out.print("\nEnter year: ");
                    int searchYear = sc.nextInt();
                    sc.nextLine();

                    System.out.println(carController.getCarByYear(searchYear));
                    break;

                // UPDATE
                case 5:
                    System.out.print("\nEnter car ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New model: ");
                    String newModel = sc.nextLine();

                    System.out.print("New year: ");
                    int newYear = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New price: ");
                    double newPrice = sc.nextDouble();
                    sc.nextLine();

                    boolean updated = carController.updateCar(
                            updateId,
                            newModel,
                            newYear,
                            newPrice
                    );

                    if (updated) {
                        System.out.println("Car updated successfully.");
                    } else {
                        System.out.println("Car not found.");
                    }

                    break;

                // DELETE
                case 6:
                    System.out.print("\nEnter car ID to delete: ");
                    int deleteId = sc.nextInt();
                    sc.nextLine();

                    boolean deleted = carController.deleteCar(deleteId);

                    if (deleted) {
                        System.out.println("Car deleted successfully.");
                    } else {
                        System.out.println("Car not found.");
                    }

                    break;

                // EXIT
                case 7:
                    System.out.println("Bye 👋");
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;
            }

        } while (option != 7);

        sc.close();
    }
}