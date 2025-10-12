package model.image;

public class AreaCalculator implements ShapeVisitor {
    private double totalArea = 0;
    double radiusOfCircle = 5;
    double sideOfSquare = 4;
    double baseOfTriangle = 3;
    double heightOfTriangle = 6;

    @Override
    public void visit(Circle circle) {
        // Calculate area of circle and update totalArea
        totalArea += Math.PI * Math.pow(radiusOfCircle, 2);
    }

    @Override
    public void visit(Square square) {
        // Calculate area of square and update totalArea
        totalArea += Math.pow(sideOfSquare, 2);
    }

    @Override
    public void visit(Triangle triangle) {
        // Calculate area of triangle and update totalArea
        totalArea += (baseOfTriangle * heightOfTriangle) / 2;
    }

    public double getTotalArea() {
        return totalArea;
    }
}
