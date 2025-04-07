public class Cylinder implements Shape {
    double radius;
    double height;
    double volume;
    double surfaceArea;

    Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double calculateVolume() {
        volume = Math.PI*Math.pow(radius, 2)*height;
        return volume;
    }

    public double calculateSurfaceArea() {
        surfaceArea = 2*Math.PI*radius*(radius+height);
        return surfaceArea;
    }
}
