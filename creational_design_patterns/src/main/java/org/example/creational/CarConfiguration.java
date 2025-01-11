package org.example.creational;

import org.example.creational.builder.Car;

public class CarConfiguration {

    public static void main(String[] args) {
        Car Car1 = new Car.Builder("V8", "Automatic")
                .setInterior("Leather Seats")
                .setColor("Black")
                .setSunroof(true)
                .setGPS(true)
                .setSafetyPackage(true)
                .build();

        System.out.println(Car1);

        Car Car2 = new Car.Builder("V6", "Manual")
                .setColor("White")
                .build();

        System.out.println(Car2);

        Car Car3 = new Car.Builder("V8", "Automatic")
                .setColor("Red")
                .setInterior("Premium Alcantara")
                .setSunroof(true)
                .setGPS(true)
                .build();

        System.out.println(Car3);
    }
}
