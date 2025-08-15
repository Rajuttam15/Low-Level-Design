package ISPViolation;

public class IspFollowed {
    public static void main(String[] args) {
        TwoDimensionalShape square1    = new Square1(5);
        TwoDimensionalShape rectangle1 = new Rectangle1(4, 6);
        ThreeDimensionalShape cube1     = new Cube1(3);

        System.out.println("Square Area: "    + square1.area());
        System.out.println("Rectangle Area: " + rectangle1.area());
        System.out.println("Cube Area: "      + cube1.area());
        System.out.println("Cube Volume: "    + cube1.volume());
    }
}

// Separate interface for 2D shapes
interface TwoDimensionalShape {
    double area();
}

// Separate interface for 3D shapes
interface ThreeDimensionalShape {
    double area();
    double volume();
}

// Square implements only the 2D interface
class Square1 implements TwoDimensionalShape {
    private double side;

    public Square1(double s) {
        this.side = s;
    }

    @Override
    public double area() {
        return side * side;
    }
}

// Rectangle implements only the 2D interface
class Rectangle1 implements TwoDimensionalShape {
    private double length, width;

    public Rectangle1(double l, double w) {
        this.length = l;
        this.width  = w;
    }

    @Override
    public double area() {
        return length * width;
    }
}

// Cube implements the 3D interface
class Cube1 implements ThreeDimensionalShape {
    private double side;

    public Cube1(double s) {
        this.side = s;
    }

    @Override
    public double area() {
        return 6 * side * side;
    }

    @Override
    public double volume() {
        return side * side * side;
    }
}