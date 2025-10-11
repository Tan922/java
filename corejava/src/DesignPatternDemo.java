import model.*;

public class DesignPatternDemo {
    public static void main(String[] args) {
        DesignPatternDemo demo = new DesignPatternDemo();
        demo.creationalDesignPatternDemo();
        demo.structuralDesignPatternDemo();
        demo.behavioralDesignPatternDemo();
    }

    private void creationalDesignPatternDemo() {
        System.out.println("--Demo creational design patterns--");
        System.out.println("----Demo Factory method Design Pattern--");
        VehicleFactory carFactory = new CarFactory();
        VehicleFactoryClient carFactoryClient = new VehicleFactoryClient(carFactory);
        Vehicle car = carFactoryClient.getVehicle();
        car.printVehicle();

        VehicleFactory truckFactory = new TruckFactory();
        VehicleFactoryClient truckFactoryClient = new VehicleFactoryClient(truckFactory);
        Vehicle truck = truckFactoryClient.getVehicle();
        truck.printVehicle();

        System.out.println("----Demo Singleton Design Pattern--");
        Singleton.getInstance().doSomething();

        System.out.println("----Demo Prototype Design Pattern--");
        // Create a concrete prototype (a red circle).
        Shape circlePrototype = new Circle("red");
        // Create a client and give it the prototype.
        ShapeClient client = new ShapeClient(circlePrototype);
        // Use the prototype to create a new shape (a red circle).
        Shape redCircle = client.createShape();
        // Draw the newly created red circle.
        redCircle.draw();

        System.out.println("----Demo Builder Design Pattern--");
        GamingComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector director = new ComputerDirector();
        director.construct(gamingBuilder);
        Computer gamingComputer = gamingBuilder.getResult();
        gamingComputer.displayInfo();
    }

    private void structuralDesignPatternDemo() {

    }

    private void behavioralDesignPatternDemo() {

    }
}

