package org.yup;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Dealership {
    public String name;
    public String address;
    public String phone;
    public List<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Dealership() {
        this.inventory = new ArrayList<>();
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> stock1 = new ArrayList<>();
        for(Vehicle vehicle: this.inventory) {
            if(vehicle.price >= min && vehicle.price <= max) {
                stock1.add(vehicle);
            }
        }
        return stock1;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> stock2 = new ArrayList<>();

        for(Vehicle vehicle : this.inventory) {
            if(vehicle.make.equalsIgnoreCase(make) && vehicle.model.equalsIgnoreCase(model)) {
                stock2.add(vehicle);
            }
        }
        return stock2;
    }

    public List<Vehicle> getVehiclesByYear(double min, double max) {
        List<Vehicle> stock3 = new ArrayList<>();

        for(Vehicle vehicle : this.inventory) {
            if(vehicle.year >= min && vehicle.year <= max) {
                stock3.add(vehicle);
            }
        }
        return stock3;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> stock4 = new ArrayList<>();

        for(Vehicle vehicle : this.inventory) {
            if(vehicle.color.equalsIgnoreCase(color)) {
                stock4.add(vehicle);
            }
        }
        return stock4;
    }

    public List<Vehicle> getVehiclesByMileage(double min, double max) {
        List<Vehicle> stock5 = new ArrayList<>();
        for (Vehicle vehicle : this.inventory) {
            if(vehicle.odometer >= min && vehicle.odometer <= max) {
                stock5.add(vehicle);
            }
        }
        return stock5;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> stock5 = new ArrayList<>();
        for(Vehicle vehicle : this.inventory) {
            if(vehicle.vehicleType.equalsIgnoreCase(vehicleType)) {
                stock5.add(vehicle);
            }
        }
        return stock5;
    }

    public List<Vehicle> getAllVehicles() {
        return this.inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        this.inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        this.inventory.remove(vehicle);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
