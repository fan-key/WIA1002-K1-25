package Q5;

public class Circle implements Comparable<Circle> {
    private double radius;
    private double area;

    public Circle(double radius) {
        this.radius = radius;
        this.area = Math.PI * Math.pow(radius, 2);
    }
    @Override
    public String toString() {
        return "Circle with radius: " + radius + ", Area: " + area;
    }

    @Override
    public int compareTo(Circle o) {
        if (this.radius > o.radius) {
            return 1;
        } else if (this.radius < o.radius) {
            return -1;
        } else {
            return 0;
        }
    }
}
