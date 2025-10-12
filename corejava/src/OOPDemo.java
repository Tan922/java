import model.*;
import model.animal.Animal;
import model.animal.Dog;
import model.computer.Computer;
import model.vehicle.Car;
import model.vehicle.Vehicle;

public class OOPDemo {
    public static void main(String[] args) {
        OOPDemo demo = new OOPDemo();
        demo.abstractionDemo();
        demo.encapsulationDemo();
        demo.inheritanceDemo();
        demo.polymorphismDemo();
    }

    private void abstractionDemo() {
        Vehicle myCar = new Car();
        myCar.startEngine();
        myCar.accelerate();
        myCar.brake();
    }

    private void encapsulationDemo() {
        Computer computer = new Computer();

        // Using setters
        computer.setCPU("Gaming CPU");
        computer.setRAM("16GB DDR4");
        computer.setStorage("1TB SSD");

        // display
        computer.displayInfo();
    }

    private void inheritanceDemo() {
        Dog myDog = new Dog();

        // Inherited methods (from Animal)
        myDog.eat();
        myDog.sleep();

        // Child class method
        myDog.bark();
    }

    private void polymorphismDemo() {
        Animal parent = new Animal();
        Dog child = new Dog();
        // Dynamic dispatch
        Animal polymorphicObj = new Dog();

        // Method Overloading (compile-time)
        parent.eat();
        parent.eat("apple");

        // Method Overriding (runtime)
        child.eat();

        // Polymorphism in action
        polymorphicObj.eat();
    }
}
