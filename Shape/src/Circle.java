public class Circle extends twoDShapes {
    private double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public double getArea() {
        double area = (Math.PI * (Math.pow(radius, 2)));
        return area;
    }

    @Override
    public double getPerimeter() {
        double circumference = (2 * (Math.PI) * radius);
        return circumference;
    }
}
