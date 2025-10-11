package model;

public class Truck extends Vehicle {
    public Truck(){
        super();
    }

    public Truck(Workshop workShop1, Workshop workShop2)
    {
        super(workShop1, workShop2);
    }

    @Override
    public void manufacture() {
        System.out.print("Truck ");
        workShop1.work();
        workShop2.work();
    }

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
