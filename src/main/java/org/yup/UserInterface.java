package org.yup;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    Dealership dealership;
    Scanner scanner;
    private UserInterface() {

    }

    public void display() {

    }

    public void processGetByPriceRequest() {
        System.out.print("Please enter a min price: ");
        double minPrice = scanner.nextDouble();

        System.out.print("Please enter max price: ");
        double maxPrice = scanner.nextDouble();

        List<Vehicle> price = dealership.getVehiclesByPrice(minPrice, maxPrice);

    }

    public void processGetByMakeModelRequest() {
        System.out.print("Please enter the make: ");
        String theMake = scanner.next();
        System.out.print("Please enter the model: ");
        String theModel = scanner.next();

        List<Vehicle> manufacturer = dealership.getVehiclesByMakeModel(theMake, theModel);

    }

    public void processGetByYearRequest() {
        System.out.print("Please enter the year: ");
        int year = scanner.nextInt();

        List<Vehicle>

    }

    public void processGetByColorRequest() {

    }

    public void processGetByMileageRequest() {

    }

    public void processGetByVehicleTypeRequest() {

    }

    public void processGetAllVehicleRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        display(vehicles);
    }

    public void processAddVechicleRequest() {

    }

    public void processRemoveVehicleRequest() {

    }
}
