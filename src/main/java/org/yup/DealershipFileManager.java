package org.yup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class DealershipFileManager {
    public Dealership getDealership() {
        Dealership dealership = new Dealership("Jon B", "2009 sw 102nd ter", "333-333-3333");

        try {
            FileReader fr = new FileReader("dealership.csv");
            BufferedReader br = new BufferedReader(fr);

            String line;
            br.readLine();
            while((line = br.readLine()) != null) {

                String[] instances = line.split("\\|");
                int vin = Integer.parseInt(instances[0]);
                int year = Integer.parseInt(instances[1]);
                String make = instances[2];
                String model = instances[3];
                String vehicleType = instances[4];
                String color = instances[5];
                int odometer = Integer.parseInt(instances[6]);
                double price = Double.parseDouble(instances[7]);

                Vehicle stockDFM = new Vehicle(vin, year, make, model,vehicleType, color, odometer, price);
                dealership.addVehicle(stockDFM);
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dealership;
    }

    public void saveDealership(Dealership dealership) {
        try {
            FileWriter fw = new FileWriter("dealership.csv");
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(dealership.getAddress() + "|" + dealership.getName() + "|" + dealership.getPhone());
            bw.newLine();

            for(Vehicle vehicle : dealership.getAllVehicles()) {
                String stockSD = String.format("%d|%d|%s|%s|%s|%s|%s",
                        vehicle.vin,
                        vehicle.year,
                        vehicle.make,
                        vehicle.model,
                        vehicle.vehicleType,
                        vehicle.color,
                        vehicle.odometer,
                        vehicle.price);
                bw.write(stockSD);
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
