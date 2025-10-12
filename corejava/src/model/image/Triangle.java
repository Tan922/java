package model.image;

public class Triangle implements Shape {
    @Override
    public Shape clone() {
        return new Triangle();
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Triangle.");
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}

