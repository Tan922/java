package model;

public abstract class Vehicle {
    protected Workshop workShop1;
    protected Workshop workShop2;

    public Vehicle(){}

    public Vehicle(Workshop workShop1, Workshop workShop2)
    {
        this.workShop1 = workShop1;
        this.workShop2 = workShop2;
    }

    abstract public void manufacture();
    public abstract void accelerate();
    public abstract void brake();
    public abstract void printVehicle();



    // Concrete method (common to all vehicles)
    public void startEngine() {
        System.out.println("Engine started!");
    }
}
