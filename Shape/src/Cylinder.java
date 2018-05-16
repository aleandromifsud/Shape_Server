public class Cylinder extends threeDShapes {
    double radius;
    double height;

    public Cylinder(String name, double radius, double height) {
        super(name);
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double getVolume() {
        double volume = ((Math.PI) * (Math.pow(radius, 2)) * height);
        return volume;
    }

    @Override
    public double getArea() {
        // Surface Area of Cylinder
        double area = ((2 * (Math.PI) * radius * height) + (2 * (Math.PI) * (Math.pow(radius, 2))));
        return area;
    }

    @Override
    public double getPerimeter() {
        double circumference = ((Math.PI) * (Math.pow(radius, 2)));
        return circumference;
    }
}
