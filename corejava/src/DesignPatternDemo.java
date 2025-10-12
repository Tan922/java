import model.*;
import model.TV.*;
import model.aviation.AirTrafficControlTower;
import model.aviation.Airplane;
import model.aviation.AirportControlTower;
import model.aviation.CommercialAirplane;
import model.beverage.*;
import model.computer.Computer;
import model.computer.ComputerDirector;
import model.computer.GamingComputerBuilder;
import model.document.Document;
import model.document.History;
import model.grammar.Context;
import model.grammar.Interpreter;
import model.image.*;
import model.printer.PrinterAdapter;
import model.request.*;
import model.sort.SortingContext;
import model.sort.SortingStrategy;
import model.task.SimpleTask;
import model.task.Task;
import model.task.TaskList;
import model.vehicle.*;
import model.vendingMachine.*;
import model.weather.Observer;
import model.weather.PhoneDisplay;
import model.weather.TVDisplay;
import model.weather.WeatherStation;

import java.util.ArrayList;
import java.util.List;

public class DesignPatternDemo {
    public static void main(String[] args) {
        DesignPatternDemo demo = new DesignPatternDemo();
        demo.creationalDesignPatternDemo();
        demo.structuralDesignPatternDemo();
        demo.behavioralDesignPatternDemo();
    }

    // creational design patterns
    private void creationalDesignPatternDemo() {
        factoryDesignPatternDemo();
        singletonDesignPatternDemo();
        prototypeDesignPatternDemo();
        buildDesignPatternDemo();
    }

    private void factoryDesignPatternDemo() {
        System.out.println("\n----Demo Factory Design Pattern--");
        VehicleFactory carFactory = new CarFactory();
        VehicleFactoryClient carFactoryClient = new VehicleFactoryClient(carFactory);
        Vehicle car = carFactoryClient.getVehicle();
        car.printVehicle();

        VehicleFactory truckFactory = new TruckFactory();
        VehicleFactoryClient truckFactoryClient = new VehicleFactoryClient(truckFactory);
        Vehicle truck = truckFactoryClient.getVehicle();
        truck.printVehicle();
    }

    private void singletonDesignPatternDemo() {
        System.out.println("\n----Demo Singleton Design Pattern--");
        Singleton.getInstance().doSomething();
    }

    private void prototypeDesignPatternDemo() {
        System.out.println("\n----Demo Prototype Design Pattern--");
        // Create a concrete prototype (a red circle).
        Shape circlePrototype = new Circle("red");
        // Create a client and give it the prototype.
        ShapeClient client = new ShapeClient(circlePrototype);
        // Use the prototype to create a new shape (a red circle).
        Shape redCircle = client.createShape();
        // Draw the newly created red circle.
        redCircle.draw();
    }

    private void buildDesignPatternDemo() {
        System.out.println("\n----Demo Builder Design Pattern--");
        GamingComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerDirector director = new ComputerDirector();
        director.construct(gamingBuilder);
        Computer gamingComputer = gamingBuilder.getResult();
        gamingComputer.displayInfo();
    }

    // Structural Design Patterns
    private void structuralDesignPatternDemo() {
        adapterDesignPatternDemo();
        bridgeDesignPatternDemo();
        compositeDesignPatternDemo();
        decoratorDesignPatternDemo();
        facadeDesignPatternDemo();
        flyweightDesignPatternDemo();
        proxyDesignPatternDemo();
    }

    private void adapterDesignPatternDemo() {
        System.out.println("\n----Demo Adapter Design Pattern--");
        PrinterAdapter adapter = new PrinterAdapter();
        adapter.print();
    }

    private void bridgeDesignPatternDemo() {
        System.out.println("\n----Demo Bridge Design Pattern--");
        Vehicle car = new Car(new Produce(), new Assemble());
        car.manufacture();
        Vehicle truck = new Truck(new Produce(), new Assemble());
        truck.manufacture();
    }

    private void compositeDesignPatternDemo() {
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
    }

    private void decoratorDesignPatternDemo() {
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
    }

    private void facadeDesignPatternDemo() {
        System.out.println("\n----Demo Facade Design Pattern--");
        System.out.println("It provides a unified, easy-to-use interface while hiding internal details, " +
                "reducing complexity for clients and promoting cleaner, more maintainable code. TBD");
    }

    private void flyweightDesignPatternDemo() {
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
    }

    private void proxyDesignPatternDemo() {
        System.out.println("\n----Demo Proxy Design Pattern--");
        Image image = new ProxyImage("example.jpg");
        // Image will be loaded from disk only when display() is called
        image.display();
        // Image will not be loaded again, as it has been cached in the Proxy
        image.display();
    }

    // Behavioral Design Patterns
    private void behavioralDesignPatternDemo() {
        chainOResponsibilityDesignPatternDemo();
        commandDesignPatternDemo();
        interpreterDesignPatternDemo();
        mediatorDesignPatternDemo();
        mementoDesignPatternDemo();
        observerDesignPatternDemo();
        stateDesignPatternDemo();
        strategyDesignPatternDemo();
        templateDesignPatternDemo();
        visitorDesignPatternDemo();
    }

    private void chainOResponsibilityDesignPatternDemo() {
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
    }

    private void commandDesignPatternDemo() {
        System.out.println("\n----Demo Command Design Pattern--");
        // Create devices
        TV tv = new TV();
        Stereo stereo = new Stereo();
        RemoteControl remote = new RemoteControl();

        // Create command objects
        Command turnOnTvCommand = new TurnOnCommand(tv::turnOn);
        Command turnOffTvCommand = new TurnOffCommand(tv::turnOff);
        Command adjustVolumeStereoCommand = new AdjustVolumeCommand(stereo::adjustVolume);
        Command changeChannelTvCommand = new ChangeChannelCommand(tv::changeChannel);

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

    private void interpreterDesignPatternDemo() {
        System.out.println("\n----Demo Interpreter Design Pattern--");
        // Input expression
        String expression = "2 + 3 * 4";

        // Create interpreter
        Context context = new Context();
        Interpreter interpreter = new Interpreter(context);

        // Interpret expression
        int result = interpreter.interpret(expression);
        System.out.println("Result: " + result);
    }

    private void mediatorDesignPatternDemo() {
        System.out.println("\n----Demo mediator Design Pattern--");
        // Instantiate the Mediator (Airport Control Tower)
        AirTrafficControlTower controlTower = new AirportControlTower();

        // Instantiate Concrete Colleagues (Commercial Airplanes)
        Airplane airplane1 = new CommercialAirplane(controlTower);
        Airplane airplane2 = new CommercialAirplane(controlTower);

        // Set up the association between Concrete Colleagues and the Mediator
        airplane1.requestTakeoff();
        airplane2.requestLanding();
    }

    private void mementoDesignPatternDemo() {
        System.out.println("\n----Demo memento Design Pattern--");
        Document document = new Document("Initial content\n");
        History history = new History();

        // Write some content
        document.write("Additional content\n");
        history.addMemento(document.createMemento());

        // Write more content
        document.write("More content\n");
        history.addMemento(document.createMemento());

        // Restore to previous state
        document.restoreFromMemento(history.getMemento(1));

        // Print document content
        System.out.println(document.getContent());
    }

    private void observerDesignPatternDemo() {
        System.out.println("\n----Demo observer Design Pattern--");
        WeatherStation weatherStation = new WeatherStation();

        Observer phoneDisplay = new PhoneDisplay();
        Observer tvDisplay = new TVDisplay();

        // Register observers
        weatherStation.addObserver(phoneDisplay);
        weatherStation.addObserver(tvDisplay);

        // Simulating weather changes
        weatherStation.setWeather("Sunny");
        weatherStation.setWeather("Rainy");
        weatherStation.setWeather("Cloudy");

        // Remove one observer
        weatherStation.removeObserver(tvDisplay);

        // Notify remaining observer
        weatherStation.setWeather("Windy");
    }

    private void stateDesignPatternDemo() {
        System.out.println("\n----Demo State Design Pattern--");
        // Create context
        VendingMachineContext vendingMachine = new VendingMachineContext();

        // Set initial state
        vendingMachine.setState(VendingMachineState.Ready);

        // Request state change
        vendingMachine.request();

        // Change state
        vendingMachine.setState(VendingMachineState.ProductSelected);

        // Request state change
        vendingMachine.request();

        // Change state
        vendingMachine.setState(VendingMachineState.PaymentPending);

        // Request state change
        vendingMachine.request();

        // Change state
        vendingMachine.setState(VendingMachineState.OutOfStock);

        // Request state change
        vendingMachine.request();
    }

    private void strategyDesignPatternDemo() {
        System.out.println("\n----Demo strategy Design Pattern--");
        // Create SortingContext with BubbleSortStrategy
        SortingContext sortingContext = new SortingContext(SortingStrategy.BubbleSort);
        int[] array1 = {5, 2, 9, 1, 5};
        sortingContext.performSort(array1); // Output: Sorting using Bubble Sort

        // Change strategy to MergeSortStrategy
        sortingContext.setSortingStrategy(SortingStrategy.MergeSort);
        int[] array2 = {8, 3, 7, 4, 2};
        sortingContext.performSort(array2); // Output: Sorting using Merge Sort

        // Change strategy to QuickSortStrategy

        sortingContext.setSortingStrategy(SortingStrategy.QuickSort);
        int[] array3 = {6, 1, 3, 9, 5};
        sortingContext.performSort(array3); // Output: Sorting using Quick Sort
    }

    private void templateDesignPatternDemo() {
        System.out.println("\n----Demo template Design Pattern--");
        System.out.println("Making tea:");
        BeverageMaker teaMaker = new TeaMaker();
        teaMaker.makeBeverage();

        System.out.println("\nMaking coffee:");
        BeverageMaker coffeeMaker = new CoffeeMaker();
        coffeeMaker.makeBeverage();
    }

    private void visitorDesignPatternDemo() {
        System.out.println("\n----Demo visitor Design Pattern--");
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle("red"));
        shapes.add(new Square());
        shapes.add(new Triangle());

        AreaCalculator areaCalculator = new AreaCalculator();
        for (Shape shape : shapes) {
            shape.accept(areaCalculator);
        }

        System.out.println("Total area: " + areaCalculator.getTotalArea());
    }
}

