public class Triangle extends twoDShapes {
    int noOfSides;
    double length;
    double width;

    public Triangle(String name, int noOfSides, double length, double width) {
        super(name);
        this.noOfSides = 3;
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        double area = ((width * length) / 2);
        return area;
    }

    @Override
    public double getPerimeter() {
        double perimeter = ((width + length) + (Math.sqrt(((Math.pow(width, 2)) + ((Math.pow(length, 2)))))));
        return perimeter;
    }
}
