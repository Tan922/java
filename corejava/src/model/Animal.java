package model;

public class Animal {
    // Overloaded method (compile-time polymorphism)
    public void eat() {
        System.out.println("Animal is eating...");
    }

    // Overloaded method (same name, different parameter)
    public void eat(String food) {
        System.out.println("Animal is eating " + food);
    }

    public void sleep() {
        System.out.println("Animal is sleeping...");
    }
}
