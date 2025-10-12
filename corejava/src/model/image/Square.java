package model.image;

public class Square implements Shape {
    @Override
    public Shape clone() {
        return new Square();
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Square.");
    }

    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}
