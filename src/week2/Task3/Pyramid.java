package week2.Task3;

public class Pyramid extends Shape{
    private double s;
    private double h;

    public Pyramid(double height, double area) {
        super(height * area / 3);
        h = height;
        s = area;
    }

    public Pyramid(double height, double area, double volume) {
        super(volume);
        h = height;
        s = area;
    }
}
