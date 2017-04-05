import java.io.*;

public class P11SerializeCustomObject {

    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/resources/";
    private static final String FILE_PATH = PROJECT_PATH + "save.ser";


    public static void main(String[] args) {
        Course course = new Course("Pesho", 21);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {

            oos.writeObject(course);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class Course implements Serializable {
    String name;
    int numberOfStudents;

    public Course(String name, int numberOfStudents) {
        this.name = name;
        this.numberOfStudents = numberOfStudents;
    }
}
