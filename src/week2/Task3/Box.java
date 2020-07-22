package week2.Task3;

import java.util.*;

public class Box extends Shape{
    private ArrayList<Shape> arr = new ArrayList<>();
    private double available;

    public Box(double size) {
        super(size);
        available = size;
    }

    public boolean add(Shape temp) {
        if (available >= temp.getVolume()) {
            available -= temp.getVolume();
            arr.add(temp);
            return true;
        } else {
            return false;
        }
    }
}
