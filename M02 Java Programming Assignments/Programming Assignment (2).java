+----------------------------------+
|         GeometricObject          |
+----------------------------------+
| - color: String                  |
| - filled: boolean                |
+----------------------------------+
| + GeometricObject()              |
| + getColor(): String             |
| + setColor(color: String): void  |
| + isFilled(): boolean            |
| + setFilled(filled: boolean): void|
+----------------------------------+
                ^
                |
                |
                |
+----------------------------------+
|            Triangle              |
+----------------------------------+
| - side1: double                  |
| - side2: double                  |
| - side3: double                  |
+----------------------------------+
| + Triangle()                     |
| + Triangle(side1: double,        |
|   side2: double, side3: double)  |
| + getSide1(): double             |
| + getSide2(): double             |
| + getSide3(): double             |
| + getArea(): double              |
| + getPerimeter(): double         |
| + toString(): String             |
+----------------------------------+


public abstract class GeometricObject {
    private String color;
    private boolean filled;

    // Default constructor
    public GeometricObject() {
        this.color = "white";
        this.filled = false;
    }

    // Accessor and mutator methods for color
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Accessor and mutator methods for filled
    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
}

public class Triangle extends GeometricObject {
    private double side1 = 1.0, side2 = 1.0, side3 = 1.0;

    // No-arg constructor
    public Triangle() {}

    // Constructor that creates a triangle with the specified sides
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // Accessor methods for all three data fields
    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    // Method that returns the area of this triangle
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    // Method that returns the perimeter of this triangle
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    // Method that returns a string description for the triangle
    public String toString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
    }
}