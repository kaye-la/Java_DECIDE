package week2.Task3;

public class SolidOfRevolution extends Shape {
    private double radius;

    public SolidOfRevolution(double radius) {
        super();
        this.radius = radius;
    }

    public SolidOfRevolution(double volume, double radius) {
        super(volume);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
