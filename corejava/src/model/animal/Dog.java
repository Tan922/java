package model.animal;

public class Dog  extends Animal {
    // Overrides Animal.eat() (runtime polymorphism)
    public void eat() {
        System.out.println("Dog is eating...");
    }

    public void bark() {
        System.out.println("Dog is barking!");
    }
}
