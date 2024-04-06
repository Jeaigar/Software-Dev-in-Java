import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void shuffle(ArrayList<Number> list) {
        Collections.shuffle(list);
    }
}

public class GeometricObject {
    // Your implementation of GeometricObject
}

public class Circle extends GeometricObject implements Comparable<Circle> {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public int compareTo(Circle o) {
        return Double.compare(this.radius, o.radius);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Circle circle = (Circle) obj;
        return Double.compare(circle.radius, radius) == 0;
    }
}
