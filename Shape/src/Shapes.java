import java.io.Serializable;

public abstract class Shapes implements Serializable {
    // This class is the parent of the 2D and 3D shape classes, it holds the name and number of sides of the shapes.
    private String name;
    private long serialVersionUID = 1L; // This variable is automatically handled by the JVM

    // Constructor of the Shapes class
    public Shapes(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getArea();

    public abstract double getPerimeter();
}
