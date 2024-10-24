package org.example;

import org.example.builder.Car;

public class CarConfiguration {

    public static void main(String[] args) {

        Car car1 = new Car.Builder()
                .setEngine("V6")
                .setTransmission("Automatic")
                .setInterior("Leather")
                .setColor("Red")
                .setSunroof(true)
                .setGPS(true)
                .setSafetyPackage(true)
                .build();

        System.out.println(car1);

        Car car2 = new Car.Builder()
                .setEngine("V8")
                .setTransmission("Manual")
                .setInterior("Fabric")
                .setColor("Black")
                .setSunroof(false)
                .setGPS(false)
                .setSafetyPackage(true)
                .build();

        System.out.println(car2);

        Car car3 = new Car.Builder()
                .setEngine("Electric")
                .setTransmission("Automatic")
                .setInterior("Leather")
                .setColor("White")
                .setSunroof(true)
                .setGPS(true)
                .setSafetyPackage(false)
                .build();

        System.out.println(car3);
    }
}
