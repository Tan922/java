import model.*;
import model.TV.*;
import model.coffee.Coffee;
import model.coffee.MilkDecorator;
import model.coffee.PlainCoffee;
import model.coffee.SugarDecorator;
import model.computer.Computer;
import model.computer.ComputerDirector;
import model.computer.GamingComputerBuilder;
import model.image.*;
import model.printer.PrinterAdapter;
import model.request.*;
import model.task.SimpleTask;
import model.task.Task;
import model.task.TaskList;
import model.vehicle.*;

public class DesignPatternDemo {
    public static void main(String[] args) {
        DesignPatternDemo demo = new DesignPatternDemo();
        demo.creationalDesignPatternDemo();
        demo.structuralDesignPatternDemo();
        demo.behavioralDesignPatternDemo();
    }

    private void creationalDesignPatternDemo() {
        System.out.println("\n--Demo creational design patterns--");
        System.out.println("----Demo Factory method Design Pattern--");
        VehicleFactory carFactory = new CarFactory();
        VehicleFactoryClient carFactoryClient = new VehicleFactoryClient(carFactory);
        Vehicle car = carFactoryClient.getVehicle();
        car.printVehicle();

        VehicleFactory truckFactory = new TruckFactory();
        VehicleFactoryClient truckFactoryClient = new VehicleFactoryClient(truckFactory);
        Vehicle truck = truckFactoryClient.getVehicle();
        truck.printVehicle();

        System.out.println("\n----Demo Singleton Design Pattern--");
        Singleton.getInstance().doSomething();

        System.out.println("\n----Demo Prototype Design Pattern--");
        // Create a concrete prototype (a red circle).
        Shape circlePrototype = new Circle("red");
        // Create a client and give it the prototype.
        ShapeClient client = new ShapeClient(circlePrototype);
        // Use the prototype to create a new shape (a red circle).
        Shape redCircle = client.createShape();
        // Draw the newly created red circle.
        redCircle.draw();

        System.out.println("\n----Demo Builder Design Pattern--");
        GamingComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector director = new ComputerDirector();
        director.construct(gamingBuilder);
        Computer gamingComputer = gamingBuilder.getResult();
        gamingComputer.displayInfo();
    }

    private void structuralDesignPatternDemo() {
        System.out.println("\n--Demo Structural Design Patterns--");
        System.out.println("----Demo Adapter Design Pattern--");
        PrinterAdapter adapter = new PrinterAdapter();
        adapter.print();

        System.out.println("\n----Demo Bridge Design Pattern--");
        Vehicle car = new Car(new Produce(), new Assemble());
        car.manufacture();
        Vehicle truck = new Truck(new Produce(), new Assemble());
        truck.manufacture();

        System.out.println("\n----Demo Composite Design Pattern--");
        // Creating simple tasks
        Task simpleTask1 = new SimpleTask("Complete Coding");
        Task simpleTask2 = new SimpleTask("Write Documentation");
        // Creating a task list
        TaskList projectTasks = new TaskList("Project Tasks");
        projectTasks.addTask(simpleTask1);
        projectTasks.addTask(simpleTask2);
        // Nested task list
        TaskList phase1Tasks = new TaskList("Phase 1 Tasks");
        phase1Tasks.addTask(new SimpleTask("Design"));
        phase1Tasks.addTask(new SimpleTask("Implementation"));
        projectTasks.addTask(phase1Tasks);
        // Displaying tasks
        projectTasks.display();

        System.out.println("\n----Demo Decorator Design Pattern--");
        // Plain Coffee
        Coffee coffee = new PlainCoffee();
        System.out.println("Description: " + coffee.getDescription());
        System.out.println("Cost: $" + coffee.getCost());
        // Coffee with Milk
        Coffee milkCoffee = new MilkDecorator(new PlainCoffee());
        System.out.println("\nDescription: " + milkCoffee.getDescription());
        System.out.println("Cost: $" + milkCoffee.getCost());
        // Coffee with Sugar and Milk
        Coffee sugarMilkCoffee = new SugarDecorator(new MilkDecorator(new PlainCoffee()));
        System.out.println("\nDescription: " + sugarMilkCoffee.getDescription());
        System.out.println("Cost: $" + sugarMilkCoffee.getCost());

        System.out.println("\n----Demo Facade Design Pattern--");
        System.out.println("It provides a unified, easy-to-use interface while hiding internal details, " +
                "reducing complexity for clients and promoting cleaner, more maintainable code. TBD");

        System.out.println("\n----Demo Flyweight Design Pattern--");
        IconFactory iconFactory = new IconFactory();
        // Draw file icons at different positions
        Icon fileIcon1 = iconFactory.getIcon("file");
        fileIcon1.draw(100, 100);
        Icon fileIcon2 = iconFactory.getIcon("file");
        fileIcon2.draw(150, 150);
        // Draw folder icons at different positions
        Icon folderIcon1 = iconFactory.getIcon("folder");
        folderIcon1.draw(200, 200);
        Icon folderIcon2 = iconFactory.getIcon("folder");
        folderIcon2.draw(250, 250);

        System.out.println("\n----Demo Proxy Design Pattern--");
        Image image = new ProxyImage("example.jpg");
        // Image will be loaded from disk only when display() is called
        image.display();
        // Image will not be loaded again, as it has been cached in the Proxy
        image.display();
    }

    private void behavioralDesignPatternDemo() {
        System.out.println("\n--Demo Behavioral Design Patterns--");
        System.out.println("----Demo Chain of Responsibility Design Pattern--");
        SupportHandler level1Handler = new Level1SupportHandler();
        SupportHandler level2Handler = new Level2SupportHandler();
        SupportHandler level3Handler = new Level3SupportHandler();

        level1Handler.setNextHandler(level2Handler);
        level2Handler.setNextHandler(level3Handler);

        Request request1 = new Request(Priority.BASIC);
        Request request2 = new Request(Priority.INTERMEDIATE);
        Request request3 = new Request(Priority.CRITICAL);

        level1Handler.handleRequest(request1);
        level1Handler.handleRequest(request2);
        level1Handler.handleRequest(request3);

        System.out.println("\n----Demo Command Design Pattern--");
        // Create devices
        TV tv = new TV();
        Stereo stereo = new Stereo();

        // Create command objects
        Command turnOnTvCommand = new TurnOnCommand(tv::turnOn);
        Command turnOffTvCommand = new TurnOffCommand(tv::turnOff);
        Command adjustVolumeStereoCommand = new AdjustVolumeCommand(stereo::adjustVolume);
        Command changeChannelTvCommand = new ChangeChannelCommand(tv::changeChannel);

        // Create remote control
        RemoteControl remote = new RemoteControl();

        // Set and execute commands
        remote.setCommand(turnOnTvCommand);
        remote.pressButton();  // Outputs: TV is now on

        remote.setCommand(adjustVolumeStereoCommand);
        remote.pressButton();  // Outputs: Volume adjusted

        remote.setCommand(changeChannelTvCommand);
        remote.pressButton();  // Outputs: Channel changed

        remote.setCommand(turnOffTvCommand);
        remote.pressButton();  // Outputs: TV is now off
    }
}

