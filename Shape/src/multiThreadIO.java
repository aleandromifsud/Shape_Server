import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class multiThreadIO extends Thread
{
    private ObjectOutputStream getStream;
    private ObjectInputStream serverInStream;
    private Socket clientConnection;
    public File shapeFile;
    private ArrayList<Shapes> shapes;




    public multiThreadIO(Socket clientConnection) throws IOException
    {
        this.clientConnection = clientConnection;
        this.getStream = new ObjectOutputStream(clientConnection.getOutputStream());
        this.serverInStream = new ObjectInputStream(clientConnection.getInputStream());
        this.shapeFile = new File("shape.ser");
    }

    @Override
    public void run()
    {
        System.out.println("Client Connected");

        // Multi threading
        while (true)
        {

            // Gets a value from the client, will proceed accordingly
            try
            {
                char clientValue = serverInStream.readChar();
                switch (clientValue)
                {
                    case 'J':
                        saveToFile();
                        clientConnection.getOutputStream().flush();
                        break;
                    case 'A':
                        getAllShapes();
                        break;
                    case 'R':
                        getRectangles();
                        break;
                    case 'C':
                        getCircles();
                        break;
                    case 'T':
                        getTriangles();
                        break;
                    case 'S':
                        getSphere();
                        break;
                    case 'Y':
                        getCylinders();
                        break;

                }
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }


    private void getAllShapes() //receive
    {
        //Writes the data from the stream to the file
        try
        {
            FileInputStream inFile = new FileInputStream(shapeFile);
            ObjectInputStream inObj = new ObjectInputStream(inFile);
            ArrayList<Shapes> temp = new ArrayList<>();
            for (Shapes shapes :((ArrayList<Shapes>)inObj.readObject()))
            {

                temp.add(shapes);
            }
            getStream.writeObject(temp);

        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

    }

    private void saveToFile()
    {
        //Serializes the shapes created and saves to file
        try
        {
            FileOutputStream outFile = new FileOutputStream(shapeFile);
            ObjectOutputStream outObj = new ObjectOutputStream(outFile);
            outObj.writeObject(serverInStream.readObject());

            FileInputStream inFile = new FileInputStream(shapeFile);
            ObjectInputStream inObj = new ObjectInputStream(inFile);
            for (Shapes shapes :((ArrayList<Shapes>)inObj.readObject()))
            {
                System.out.println(shapes.getName());
            }
            getStream.reset();
            System.out.println("Contents saved in file ");

        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

    }

    private void getTriangles()
    {
        try
        {
            FileInputStream inFile = new FileInputStream(shapeFile);
            ObjectInputStream inObj = new ObjectInputStream(inFile);
            shapes = (ArrayList<Shapes>) inObj.readObject();
            System.out.println(shapes);

            for (int i = 0; i < shapes.size(); i++)
            {
                for (Shapes shapes : shapes)
                {
                    getStream.writeObject(shapes.getClass().getName().equals("Triangle"));
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    private void getRectangles()
    {
        try
        {
            FileInputStream inFile = new FileInputStream(shapeFile);
            ObjectInputStream inObj = new ObjectInputStream(inFile);
            shapes = (ArrayList<Shapes>) inObj.readObject();
            System.out.println(shapes);

            for (int i = 0; i < shapes.size(); i++)
            {
                for (Shapes shapes : shapes)
                {
                    getStream.writeObject(shapes.getClass().getName().equals("Rectangle"));
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }


    private void getCircles()   //Get all the circles from the File
    {
        try
        {
            FileInputStream inFile = new FileInputStream(shapeFile);
            ObjectInputStream inObj = new ObjectInputStream(inFile);
            shapes = (ArrayList<Shapes>) inObj.readObject();
            System.out.println(shapes);

            for (int i = 0; i < shapes.size(); i++)
            {
                for (Shapes shapes : shapes)
                {
                    getStream.writeObject(shapes.getClass().getName().equals("Circle"));
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    private void getCylinders()
    {
        try
        {
            FileInputStream inFile = new FileInputStream(shapeFile);
            ObjectInputStream inObj = new ObjectInputStream(inFile);
            shapes = (ArrayList<Shapes>) inObj.readObject();
            System.out.println(shapes);

            for (int i = 0; i < shapes.size(); i++)
            {
                for (Shapes shapes : shapes)
                {
                    getStream.writeObject(shapes.getClass().getName().equals("Cylinder"));
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    private void getSphere()
    {
        try
        {
            FileInputStream inFile = new FileInputStream(shapeFile);
            ObjectInputStream inObj = new ObjectInputStream(inFile);
            shapes = (ArrayList<Shapes>) inObj.readObject();
            System.out.println(shapes);

            for (int i = 0; i < shapes.size(); i++)
            {
                for (Shapes shapes : shapes)
                {
                    getStream.writeObject(shapes.getClass().getName().equals("Sphere"));
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

}
