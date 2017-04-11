package Problem_01_Reflection;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class reflectionClass = Class.forName("Problem_01_Reflection.Reflection");

        System.out.println(reflectionClass);

        Class parent = reflectionClass.getSuperclass();

        System.out.println(parent);

        Class[] interfaces = reflectionClass.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }

        Object obj = reflectionClass.newInstance();
        System.out.println(obj);
    }
}
