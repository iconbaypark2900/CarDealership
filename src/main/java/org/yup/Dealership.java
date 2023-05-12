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

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> stock = new ArrayList<>();
        return stock;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> stock = new ArrayList<>();
        return stock;
    }

    public List<Vehicle> getVehiclesByYear(double min, double max) {
        List<Vehicle> stock = new ArrayList<>();
        return stock;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> stock = new ArrayList<>();
        return stock;
    }

    public List<Vehicle> getVehiclesByMileage(double min, double max) {
        List<Vehicle> stock = new ArrayList<>();
        return stock;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
        List<Vehicle> stock = new ArrayList<>();
        return stock;
    }

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> stock = new ArrayList<>();
        return stock;
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
