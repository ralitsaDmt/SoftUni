package Problem_01_Reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Comparator;

public class Problem_02_Methods {
    public static void main(String[] args) {
        Class reflectionClass = Reflection.class;

        Method[] allMethods = reflectionClass.getDeclaredMethods();

        Method[] getters = Arrays.stream(allMethods)
                .filter(m -> m.getName().startsWith("get"))
                .toArray(Method[]::new);
        Method[] setters = Arrays.stream(allMethods)
                .filter(m -> m.getName().startsWith("set"))
                .toArray(Method[]::new);

        Arrays.sort(setters, Comparator.comparing(Method::getName));
        Arrays.sort(getters, Comparator.comparing(Method::getName));

        for (Method getter : getters) {
            String name = getter.getName();
            Type type = getter.getReturnType();
            String output = String.format("%s will return %s",
                    name, type);
            System.out.println(output);
        }

        for (Method setter : setters) {
            String name = setter.getName();
            Type type = setter.getParameterTypes()[0];
            String output = String.format("%s and will set field of %s",
                    name, type);
            System.out.println(output);
        }
    }
}
