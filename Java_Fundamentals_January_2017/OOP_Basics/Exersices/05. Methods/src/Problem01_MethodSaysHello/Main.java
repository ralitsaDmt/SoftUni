package Problem01_MethodSaysHello;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IOException {


        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String name = reader.readLine();

        Person person = new Person(name);

        person.sayHelo();

    }
}

class Person {

    private String name;

    private void setName(String name) {
        this.name = name;
    }

    public Person(String name){
        this.setName(name);
    }

    public void sayHelo(){
        System.out.println(this.name + " says \"Hello\"!");
    }
}

