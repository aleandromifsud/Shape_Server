import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client
{
    private ObjectOutputStream sendToServer;
    private ObjectInputStream readFromFile;
    private int choice;
    private Socket client;
    private String receiveChoice;
    private ArrayList<Shapes> shapeArray;
    private ArrayList<Shapes> newShapesArray;

    public Client(Socket client) throws IOException
    {
        this.client = client;
        this.sendToServer = new ObjectOutputStream(client.getOutputStream());
        this.readFromFile = new ObjectInputStream(client.getInputStream());
        this.shapeArray = new ArrayList<>();
        this.newShapesArray = new ArrayList<>();
    }

    public static void main(String args[]) throws IOException
    {
        Client newClient = new Client(new Socket("127.0.0.1", 555));

        try
        {

            while (true)
            {
                newClient.initialMenu();
            }
        } catch (IOException ex)
        {
            System.out.println("ERROR :" + ex.getMessage() + " .");
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public void initialMenu() throws IOException, ClassNotFoundException
    {
        // Output the initial menu

        System.out.println("1.\tCreate 2D Shape");
        System.out.println("2.\tCreate 3D Shape");
        System.out.println("3.\tSend Shapes To File");
        System.out.println("4.\tSelect existing Shapes");
        System.out.println("5.\tExit");

        // Get the users input
        choice = new Scanner(System.in).nextInt();

        // Opening a menu depending on the input
        switch (choice)
        {

            // 2D Shape chosen

            case 1:

                System.out.println("Choose a 2D Shape : ");

                System.out.println("1.\tCreate a Triangle");
                System.out.println("2.\tCreate a Circle");
                System.out.println("3.\tCreate a Rectangle");
                System.out.println("4.\tGo Back");
                System.out.println("5.\tExit");

                choice = new Scanner(System.in).nextInt();
                twoDimensionMenu();

                break;

            case 2:
                System.out.println("Choose a 3D Shape : ");

                System.out.println("1.\tCreate a Sphere");
                System.out.println("2.\tCreate a Cylinder");
                System.out.println("3.\tGo Back");
                System.out.println("4.\tExit");

                choice = new Scanner(System.in).nextInt();
                threeDimensionMenu();

                break;

            case 3:

                try
                {
                    System.out.println("Sending to Server...");
                    sendToServer.writeChar('J');
                    sendToServer.writeObject(shapeArray);
                    sendToServer.flush();
                    // This will notify the server that the user requested to save.
                    System.out.println("Shapes saved");
                    break;
                } catch (IOException e)
                {
                    e.printStackTrace();
                }

                break;

            case 4:
                System.out.println("Choose what Shapes to receive");
                System.out.println("1.\tType 'A' for all shapes");
                System.out.println("2.\tType 'R' for all rectangles");
                System.out.println("3.\tType 'C' for all circles");
                System.out.println("4.\tType 'T' for all triangles");
                System.out.println("5.\tType 'S' for all spheres");
                System.out.println("6.\tType 'Y' for all cylinders");

                filteredMenu();
                break;

            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Incorrect Input");
                break;
        }
    }


    private void filteredMenu()
    {
        try
        {
        // Awaiting input from the user
        receiveChoice = new Scanner (System.in).nextLine();
        char receiveChar = receiveChoice.charAt(0);

        switch (receiveChar)
        {
            // Sending 'A' - Requesting all shapes from the server
            case 'A':
                client.getOutputStream().flush();
                sendToServer.writeChar('A');
                sendToServer.reset();
                newShapesArray = (ArrayList<Shapes>) readFromFile.readObject();

                for (Shapes menuSend : newShapesArray)
                {
                    System.out.println(
                            " Name: "+menuSend.getName() +
                            " Type: " + menuSend.getClass().getName()+
                            " Area: "+menuSend.getArea()+
                            " Perimeter: "+menuSend.getPerimeter());
                }
                break;

            // Sending 'R' - Requesting all Rectangles from the server
            case 'R':

                client.getOutputStream().flush();
                sendToServer.writeChar('R');
                sendToServer.reset();
                newShapesArray = (ArrayList<Shapes>) readFromFile.readObject();

                for (Shapes menuSend : newShapesArray)
                {
                    System.out.println(
                            " Name: "+menuSend.getName() +
                            " Type: " + menuSend.getClass().getName()+
                            " Area: "+menuSend.getArea()+
                            " Perimeter: "+menuSend.getPerimeter());
                }
                break;

            // Sending 'C' - Requesting all Circles from the server
            case 'C':
                client.getOutputStream().flush();
                sendToServer.writeChar('C');
                sendToServer.reset();
                newShapesArray = (ArrayList<Shapes>) readFromFile.readObject();

                for (Shapes menuSend : newShapesArray)
                {
                    System.out.println(
                            " Name: "+menuSend.getName() +
                            " Type: " + menuSend.getClass().getName()+
                            " Area: "+menuSend.getArea()+
                            " Perimeter: "+menuSend.getPerimeter());
                }
                break;

            // Sending 'T' - Requesting all Triangles from the server
            case 'T':
                client.getOutputStream().flush();
                sendToServer.writeChar('T');
                sendToServer.reset();
                newShapesArray = (ArrayList<Shapes>) readFromFile.readObject();

                for (Shapes menuSend : newShapesArray)
                {
                    System.out.println(
                            " Name: "+menuSend.getName() +
                            " Type: " + menuSend.getClass().getName()+
                            " Area: "+menuSend.getArea()+
                            " Perimeter: "+menuSend.getPerimeter());
                }
                break;

            // Sending 'S' - Requesting all Spheres from the server
            case 'S':
                client.getOutputStream().flush();
                sendToServer.writeChar('S');
                sendToServer.reset();
                newShapesArray = (ArrayList<Shapes>) readFromFile.readObject();

                for (Shapes menuSend : newShapesArray)
                {
                    System.out.println(
                            " Name: "+menuSend.getName() +
                            " Type: " + menuSend.getClass().getName()+
                            " Area: "+menuSend.getArea()+
                            " Perimeter: "+menuSend.getPerimeter());
                }
                break;

            // Sending 'Y' - Requesting all Cylinder from the server
            // The letter Y is used as C is already used taken by Circle
            case 'Y':
                client.getOutputStream().flush();
                sendToServer.writeChar('Y');
                sendToServer.reset();
                newShapesArray = (ArrayList<Shapes>) readFromFile.readObject();

                for (Shapes menuSend : newShapesArray)
                {
                    System.out.println(
                            " Name: "+menuSend.getName() +
                            " Type: " + menuSend.getClass().getName()+
                            " Area: "+menuSend.getArea()+
                            " Perimeter: "+menuSend.getPerimeter());
                }
                break;
            default:
                System.out.println("Incorrect Input");
                break;
        }
    } catch (IOException e)
    {
        e.printStackTrace();
    } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }


    private void twoDimensionMenu() throws IOException, ClassNotFoundException
    {
        String shapeName;
        double length;
        double radius;
        double width;

        switch (choice)
        {
            // Triangle Case - Handles Input of Triangle Details
            case 1:

                System.out.println("Triangle");
                System.out.println("Please enter the triangle name");
                // Name -Waiting for user input
                shapeName = new Scanner(System.in).nextLine();

                System.out.println(" Enter the triangles width");
                width = new Scanner(System.in).nextDouble();

                System.out.println(" Enter the triangles length");
                length = new Scanner(System.in).nextDouble();

                //Adding the shape to the Array List
                shapeArray.add(new Triangle(shapeName, 3, length, width));

                //Outputting the results to the user
                Triangle triangleObj = new Triangle(shapeName, 3, length, width);
                System.out.println("The area of " + shapeName + " is : " + triangleObj.getArea());
                System.out.println("The perimeter of " + shapeName + " is : " + triangleObj.getPerimeter());

                // Going back to the main menu
                System.out.println("Redirecting to main menu... \n");
                initialMenu();

                break;

            // Circle Case - Handles Input of Circle Details
            case 2:

                System.out.println("Circle");
                System.out.println("Please enter the Circle name");
                shapeName = new Scanner(System.in).nextLine();

                System.out.println(" Enter the Circle radius");
                radius = new Scanner(System.in).nextDouble();

                // Adding the circle to the arraylist
                shapeArray.add(new Circle(shapeName, radius));

                Circle circObj = new Circle(shapeName, radius);
                System.out.println("The area of " + shapeName + " is : " + circObj.getArea());
                System.out.println("The circumference of " + shapeName + " is : " + circObj.getPerimeter());

                System.out.println("Redirecting to main menu... \n");
                initialMenu();
                break;

            // Rectangle
            case 3:
                System.out.println("Rectangle");
                System.out.println("Please enter the Rectangle name");
                shapeName = new Scanner(System.in).nextLine();

                System.out.println(" Enter the Rectangle width");
                width = new Scanner(System.in).nextDouble();

                System.out.println(" Enter the Rectangle length");
                length = new Scanner(System.in).nextDouble();

                //Adding the rectangle to the array list
                shapeArray.add(new Rectangle(shapeName, 4, width, length));

                //Outputting the results to the user
                Rectangle rectObj = new Rectangle(shapeName, 4, width, length);
                System.out.println("The area of " + shapeName + " is : " + rectObj.getArea());
                System.out.println("The perimeter of " + shapeName + " is : " + rectObj.getPerimeter());

                System.out.println("Redirecting to main menu... \n");
                initialMenu();
                break;

            // Back
            case 4:
                initialMenu();
                break;

            // Exit
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Incorrect Input");
                break;
        }

    }

    private void threeDimensionMenu() throws IOException, ClassNotFoundException
    {
        String shapeName;
        double height;
        double radius;

        switch (choice)
        {

            // Sphere
            case 1:
                System.out.println("Sphere");

                System.out.println("Please enter the Spheres name");
                shapeName = new Scanner(System.in).nextLine();

                System.out.println(" Enter the Spheres radius");
                radius = new Scanner(System.in).nextDouble();

                // Adding the sphere to the arraylist
                shapeArray.add(new Sphere(shapeName, radius));

                // Outputting the data to the user
                Sphere sphereObj = new Sphere(shapeName, radius);
                System.out.println("The surface area of " + shapeName + " is : " + sphereObj.getArea());
                System.out.println("The circumference of " + shapeName + " is: " + sphereObj.getPerimeter());
                System.out.println("The volume of " + shapeName + " is: " + sphereObj.getVolume());

                System.out.println("Redirecting to main menu... \n");
                initialMenu();
                break;

            // Cylinder
            case 2:
                System.out.println("Cylinder");

                System.out.println("Please enter the Cylinders name");
                shapeName = new Scanner(System.in).nextLine();

                System.out.println(" Enter the Sphere radius");
                radius = new Scanner(System.in).nextDouble();

                System.out.println(" Enter the Sphere height");
                height = new Scanner(System.in).nextDouble();

                //Adding the shapes to the array
                shapeArray.add(new Cylinder(shapeName, radius, height));

                Cylinder cylindereObj = new Cylinder(shapeName, radius, height);
                System.out.println("The surface area of " + shapeName + " is : " + cylindereObj.getArea());
                System.out.println("The circumference of " + shapeName + " is: " + cylindereObj.getPerimeter());
                System.out.println("The volume of " + shapeName + " is: " + cylindereObj.getVolume());

                System.out.println("Redirecting to main menu... \n");

                initialMenu();
                break;

            // Back
            case 3:
                initialMenu();
                break;

            // Exit
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Incorrect Input");
                break;
        }

    }


}
