package model;

public abstract class Vehicle {
    // Abstract methods (what it can do)
    public abstract void accelerate();
    public abstract void brake();

    // Concrete method (common to all vehicles)
    public void startEngine() {
        System.out.println("Engine started!");
    }
}
