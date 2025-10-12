package model.image;

public interface Shape {
    Shape clone();  // Make a copy of itself
    void draw();    // Draw the shape
    void accept(ShapeVisitor visitor);
}
