public class Rectangle extends twoDShapes {
    int noOfSides;
    private double width;
    private double length;

    public Rectangle(String name, int noOfSides, double width, double length) {
        super(name);
        this.noOfSides = 4;
        this.width = width;
        this.length = length;
    }

    @Override
    public double getArea() {
        double area = (width * length);
        return area;
    }

    @Override
    public double getPerimeter() {
        double perimeter = (2 * (length * width));
        return perimeter;
    }
}
