package org.yup;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    Dealership dealership;
    Scanner scanner;
    public UserInterface() {
        init();
        this.scanner = new Scanner(System.in);
    }

//    public void example() {
//        List<String> hues = new ArrayList<>();
//        hues.add("green");
//        hues.add("red");
//        hues.add("blue");
//
//        hues.contains("orange");
//    }

    public void display() {
        System.out.println("--------Menu--------");
        System.out.println("1) Price ");
        System.out.println("2) Make & Model");
        System.out.println("3) Year");
        System.out.println("4) Color");
        System.out.println("5) Mileage");
        System.out.println("6) Body Style");
        System.out.println("7) Get All");
        System.out.println("8) Add");
        System.out.println("9) Remove");
        System.out.print("Enter choice: ");

        int pick = scanner.nextInt();
        switch (pick) {
            case 1:
                processGetByPriceRequest();
                break;
            case 2:
                processGetByMakeModelRequest();
                break;
            case 3:
                processGetByYearRequest();
                break;
            case 4:
                processGetByColorRequest();
                break;
            case 5:
                processGetByMileageRequest();
                break;
            case 6:
                processGetByVehicleTypeRequest();
                break;
            case 7:
                processGetAllVehicleRequest();
                break;
            case 8:
                processAddVehicleRequest();
                break;
            case 9:
                processRemoveVehicleRequest();
                break;
        }

    }

    public void processGetByPriceRequest() {
        System.out.print("Please enter a min price: ");
        double minPrice = scanner.nextDouble();

        System.out.print("Please enter max price: ");
        double maxPrice = scanner.nextDouble();

        List<Vehicle> price = dealership.getVehiclesByPrice(minPrice, maxPrice);
        for(Vehicle vehicle : price) {
            System.out.println("vin: " + vehicle.getVin() + ", year: " + vehicle.getYear() + ", make: " + vehicle.getMake() + ", model: " + vehicle.getModel() + ", color: " + vehicle.getColor() + ", mileage: " + vehicle.getOdometer() + ", body style: " + vehicle.getVehicleType() + ", price: "+vehicle.getPrice()
            );
        }

    }

    public void processGetByMakeModelRequest() {
        System.out.print("Please enter the make: ");
        String theMake = scanner.next();
        System.out.print("Please enter the model: ");
        String theModel = scanner.next();

        List<Vehicle> manufacturer = dealership.getVehiclesByMakeModel(theMake, theModel);
        for (Vehicle vehicle : manufacturer) {
            System.out.println("make: " + vehicle.getMake()+ ", model: " + vehicle.getModel()+ ", vin: " + vehicle.getVin() + ", year: " + vehicle.getYear() + ", color: " + vehicle.getColor() + ", mileage: " + vehicle.getOdometer() + ", body style: " + vehicle.getVehicleType() + ", price: " + vehicle.getPrice()
            );
        }

    }

    public void processGetByYearRequest() {
        System.out.print("Please enter the min year: ");
        int minYear = scanner.nextInt();
        System.out.print("Please enter the max year: ");
        int maxYear = scanner.nextInt();

        List<Vehicle> yearConcept = dealership.getVehiclesByYear(minYear, maxYear);
        for (Vehicle vehicle : yearConcept) {
            System.out.println("year: " + vehicle.getYear() + ", vin: " + vehicle.getVin() + ", make: " + vehicle.getMake() + ", model: " + vehicle.getModel() + ", color: " + vehicle.getColor() + ", mileage: " + vehicle.getOdometer() + ", body style: " + vehicle.getVehicleType() + ", price: " + vehicle.getPrice()
            );
        }

    }

    public void processGetByColorRequest() {
        System.out.print("Please enter the color: ");
        String color = scanner.next();

        List<Vehicle> hues = dealership.getVehiclesByColor(color);
        for (Vehicle vehicle : hues) {
            System.out.println(vehicle.getColor());
        }
    }

    public void processGetByMileageRequest() {
        System.out.print("Please enter the min mileage");
        int minMileage = scanner.nextInt();
        System.out.println("Please enter the max mileage");
        int maxMileage = scanner.nextInt();

        List<Vehicle> odometer = dealership.getVehiclesByMileage(minMileage, maxMileage);
        for(Vehicle vehicle : odometer){
            System.out.println(vehicle.getOdometer());
        }
    }

    public void processGetByVehicleTypeRequest() {
        System.out.print("Please enter the vehicle type: ");
        String carType = scanner.next();

        List<Vehicle> bodyStyle = dealership.getVehiclesByType(carType);
        for(Vehicle vehicle : bodyStyle) {
            System.out.println(vehicle.getVehicleType());
        }
    }

    public void processGetAllVehicleRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        for(Vehicle vehicle : vehicles) {
            System.out.println(
                    "vin: " + vehicle.getVin() + ", year: " + vehicle.getYear() + ", make: " + vehicle.getMake() + ", model: " + vehicle.getModel() + ", color: " + vehicle.getColor() + ", mileage: " + vehicle.getOdometer() + ", body style: " + vehicle.getVehicleType() + ", price: " + vehicle.getPrice()
            );
        }
    }

    public void processAddVehicleRequest() {
        System.out.print("Enter vin: ");
        int vin = scanner.nextInt();

        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        System.out.print("Enter make: ");
        String make = scanner.next();

        System.out.print("Enter model: ");
        String model = scanner.next();

        System.out.print("Enter color: ");
        String color = scanner.next();

        System.out.print("Enter mileage: ");
        int odometer= scanner.nextInt();

        System.out.print("Enter Body Style: ");
        String vehicleType = scanner.next();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();

       Vehicle newWhip = new Vehicle(vin,year,make,model,vehicleType,color,odometer,price);
       dealership.addVehicle(newWhip);

       DealershipFileManager dfm = new DealershipFileManager();
       dfm.saveDealership(dealership);
    }

    public void processRemoveVehicleRequest() {
        System.out.println("Enter vin");
        int vin = scanner.nextInt();

        boolean success = dealership.removeVehicle(vin);
        if(success) {
            System.out.println("Vehicle removed successfully.");
        } else {
            System.out.println("none from this vin");
        }
    }

    private void init() {
        DealershipFileManager dfm = new DealershipFileManager();
        this.dealership = dfm.getDealership() ;
    }
}
