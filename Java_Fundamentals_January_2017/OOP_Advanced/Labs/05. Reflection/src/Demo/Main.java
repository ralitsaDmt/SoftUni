package Demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Class clazz = (Class) Class.forName("Demo.Person");

        Field[] allPublicFields = clazz.getFields();
        Field[] allFields = clazz.getDeclaredFields();

        Class citizen = Citizen.class;
        Class parrent = citizen.getSuperclass();

        Field[] superclassFields = parrent.getFields();

        String parrentName = parrent.getSimpleName();
        String parrentPath = parrent.getName();

        Class reflectionClass = Reflection.class;

        Constructor construvtor = reflectionClass.getConstructor();
        Constructor[] cons = reflectionClass.getConstructors();

        for (Constructor con : cons) {

        }

        String debug = "";

    }
}
