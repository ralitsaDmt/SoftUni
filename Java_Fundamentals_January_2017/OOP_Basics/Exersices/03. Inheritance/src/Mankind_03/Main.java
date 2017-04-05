package Mankind_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        String[] studentData = in.readLine().split("\\s+");

        String firstName = studentData[0];
        String lastName = studentData[1];
        String facNumber = studentData[2];

        String[] workerData = in.readLine().split("\\s+");
        String workerFirstName = workerData[0];
        String workerLastName = workerData[1];
        double salary = Double.parseDouble(workerData[2]);
        double workingHours = Double.parseDouble(workerData[3]);

        try {
            Student student = new Student(firstName, lastName, facNumber);
            System.out.println(student);

            System.out.println();

            Worker worker = new Worker(workerFirstName, workerLastName, salary, workingHours);
            System.out.println(worker);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
