package week2.Task3;

public class Cylinder extends SolidOfRevolution{
    private double height;

    public Cylinder(double radius, double height) {
        super(Math.PI * radius * radius * height, radius);
        this.height = height;
    }

    public Cylinder(double volume, double radius, double height) {
        super(volume, radius);
        this.height = height;
    }
}
