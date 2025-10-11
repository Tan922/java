import model.*;

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
        Employee emp = new Employee();

        // Using setters
        emp.setId(101);
        emp.setName("Tony");

        // Using getters
        System.out.println("Employee ID: " + emp.getId());
        System.out.println("Employee Name: " + emp.getName());
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
