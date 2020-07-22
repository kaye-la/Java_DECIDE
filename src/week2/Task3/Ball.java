package week2.Task3;

public class Ball extends SolidOfRevolution{
    public Ball(double radius) {
        super(4 * Math.PI * Math.pow(radius, 3) / 3, radius);
    }

    public Ball(double volume, double radius) {
        super(volume, radius);
    }
}
