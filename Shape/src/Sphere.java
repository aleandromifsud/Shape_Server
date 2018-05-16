public class Sphere extends threeDShapes {
    double radius;

    public Sphere(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        double volume = ((4 / 3) * (Math.PI) * (Math.pow(radius, 3)));
        return volume;
    }

    @Override
    public double getArea() {
        double area = ((4 * (Math.PI) * (Math.pow(radius, 2))));
        return area;
    }

    @Override
    public double getPerimeter() {
        double circumference = ((4 / 3) * (Math.PI) * (Math.pow(radius, 3)));
        return circumference;
    }

}
