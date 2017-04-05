import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Demo {

    private static final String objectPath = "D:\\object.ser";

    public static void main(String[] args) {

        Cube cube = new Cube();
        cube.color = "green";
        cube.height = 12.5;




    }
}

class Cube implements Serializable{
    String color;
    double height;
}