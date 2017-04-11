package pr02PrivateClassFiddling;

import pr02PrivateClassFiddling.com.peshoslav.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, IOException, NoSuchFieldException, NoSuchMethodException {
		Class blackBoxClass = BlackBoxInt.class;
		Object instance = instantiateClass(blackBoxClass);
		readCommands(instance);

		String debug = "";
	}

	private static Object instantiateClass(Class blackBoxClass) throws IllegalAccessException, InvocationTargetException, InstantiationException {
		Constructor[] constructors = blackBoxClass.getDeclaredConstructors();
		Constructor defaultConstructor = null;
		for (Constructor constructor : constructors) {
			if (constructor.getParameterCount() == 0) {
				defaultConstructor = constructor;
			}
		}
		defaultConstructor.setAccessible(true);
		Object instance = defaultConstructor.newInstance();
		return instance;
	}

	private static void readCommands(Object instance) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
		BufferedReader reader =
				new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String commandLine = reader.readLine();
			if ("END".equals(commandLine)) {
				break;
			}

			String[] commandData = commandLine.split("_");
			String command = commandData[0];
			int value = Integer.parseInt(commandData[1]);
			executeCommand(command, value, instance);
		}
	}

	private static void executeCommand(String command, int value, Object instance) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
		Class instanceClass = instance.getClass();
		Method[] methods = instanceClass.getDeclaredMethods();
		Method method = null;

		for (Method method1 : methods) {
			String name = method1.getName();
			if (name.equals(command)) {
				method = method1;
				break;
			}
		}
		method.setAccessible(true);
		method.invoke(instance, value);
		int result = getInnerValue(instance);
		System.out.println(result);
	}

	private static int getInnerValue(Object instance) throws NoSuchFieldException, IllegalAccessException {
		Field innerField = instance.getClass().getDeclaredField("innerValue");
		innerField.setAccessible(true);
		int innerValue = innerField.getInt(instance);
		return innerValue;
	}

}
