package pr01HarvestingFields;

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {

		Class harvester = RichSoilLand.class;

		List<Field> fields = Arrays.asList(harvester.getDeclaredFields());
		List<Field> privateFields = new LinkedList<>();
		List<Field> publicFields = new LinkedList<>();
		List<Field> protectedFields = new LinkedList<>();

		for (Field field : fields) {
			if (Modifier.isPrivate(field.getModifiers())){
				privateFields.add(field);
			} else if (Modifier.isPublic(field.getModifiers())){
				publicFields.add(field);
			} else if (Modifier.isProtected(field.getModifiers())){
				protectedFields.add(field);
			}
		}

		BufferedReader reader =
				new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String command = reader.readLine();
			if ("HARVEST".equals(command)) {
				break;
			}

			switch (command){
				case "private":
					printFields(privateFields);
					break;
				case "public":
					printFields(publicFields);
					break;
				case "protected":
					printFields(protectedFields);
					break;
				case "all":
					printFields(fields);
					break;
			}
		}
	}

	private static void printFields(List<Field> fields){
		for (Field field : fields) {
			String accessModifier = getAccessModifier(field);
			String type = field.getType().getSimpleName();
			String name = field.getName();

			String output = String.format("%s %s %s",
					accessModifier, type, name);
			System.out.println(output);
		}
	}

	private static String getAccessModifier(Field field){
		String modifiers = Modifier.toString(field.getModifiers());
		int separatorIndex = modifiers.length();
		if (modifiers.contains(" ")){
			separatorIndex = modifiers.indexOf(" ");
		}
		String accessModifier = modifiers.substring(0, separatorIndex);
		return accessModifier;
	}
}
