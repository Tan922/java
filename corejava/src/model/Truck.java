package model;

public class Truck extends Vehicle {
    @Override
    public void accelerate() {
        System.out.println("Truck: Pressing gas pedal...");
        // Hidden complex logic: fuel injection, gear shifting, etc.
    }

    @Override
    public void brake() {
        System.out.println("Truck: Applying brakes...");
        // Hidden logic: hydraulic pressure, brake pads, etc.
    }

    @Override
    public void printVehicle() {
        System.out.println("I am a truck");
    }
}
