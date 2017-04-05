package FamilyTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    // private static List<Person> people;
    private static Map<String, Person> peopleByName;
    private static Map<Date, Person> peopleByDate;
    private static List<Person> peopleWithFullData;

    public static void main(String[] args) throws IOException {

        BufferedReader in =
                new BufferedReader(new InputStreamReader(System.in));

        peopleByName = new HashMap<>();
        peopleByDate = new HashMap<>();
        peopleWithFullData = new LinkedList<>();

        // people = new LinkedList<>();

        String personInfo = in.readLine();

        while (true){
            String inputData = in.readLine();
            if (inputData.equals("End")){
                break;
            }

            if (!inputData.contains("-")) {
                addPersonWithFullData(inputData);
            } else {
                String[] data = inputData.split("-");
                String parentData = data[0].trim();
                String childData = data[1].trim();

                Person parent = createPerson(parentData);
                Person child = createPerson(childData);

                parent.addChild(child);
                child.addParent(parent);
            }
        }

        fillMissingData();

        Person personToPrint = collectDataForOnePerson(personInfo);

        printPersonInfo(personToPrint);
    }

    private static void printPersonInfo(Person person) {
        System.out.println(person);
        System.out.println("Parents:");
        for (Person parent : person.getParents()) {
            System.out.println(parent);
        }
        System.out.println("Children:");
        for (Person child : person.getChildren()) {
            System.out.println(child);
        }
    }

    private static Person collectDataForOnePerson(String personInfo) {
        if (isName(personInfo)) {
            String name = personInfo;
            Date birthDate = null;

            for (Person person : peopleWithFullData) {
                if (name.equals(person.getName())) {
                    birthDate = person.getBirthDate();
                    break;
                }
            }

            Person personByName = collectDataByName(personInfo);

            if (birthDate == null && personByName.getBirthDate() != null) {
                birthDate = personByName.getBirthDate();
            }

            Person personByDate = null;
            if (birthDate != null) {
                personByDate = collectDataByDate(birthDate);
            }

            if (personByDate != null) {
                personByName.setBirthDate(personByDate.getBirthDate());
                for (Person child : personByDate.getChildren()) {
                    personByName.addChild(child);
                }
                for (Person parent : personByDate.getParents()) {
                    personByName.addParent(parent);
                }
            }

            return personByName;

        } else {
            Date birthDate = convertToDate(personInfo);
            String name = null;

            for (Person person : peopleWithFullData) {
                if (birthDate.equals(person.getBirthDate())) {
                    name = person.getName();
                }
            }

            Person personByDate = collectDataByDate(birthDate);

            if (name == null && personByDate.getName() != null) {
                name = personByDate.getName();
            }

            Person personByName = null;
            if (name != null) {
                personByName = collectDataByName(name);
            }

            if (personByName != null) {
                personByDate.setName(personByName.getName());
                for (Person child : personByName.getChildren()) {
                    personByDate.addChild(child);
                }
                for (Person parent : personByName.getParents()) {
                    personByDate.addParent(parent);
                }
            }

            return personByDate;
        }
    }

    private static Person collectDataByDate(Date birthDate) {
        Person person = new Person(birthDate);

        if (peopleByDate.containsKey(birthDate)) {
            Person personByDate = peopleByDate.get(birthDate);
            if (personByDate.getBirthDate() != null) {
                person.setName(personByDate.getName());
            }
        }

        for (Person personByDate : peopleByDate.values()) {
            for (Person parent : personByDate.getParents()) {
                if (birthDate.equals(parent.getBirthDate())) {
                    person.addChild(personByDate);
                }
            }

            for (Person child : personByDate.getChildren()) {
                if (birthDate.equals(child.getBirthDate())) {
                    person.addParent(personByDate);
                }
            }
        }

        return person;
    }

    private static Person collectDataByName(String name) {
        Person person = new Person(name);

        if (peopleByName.containsKey(name)) {
            Person personByName = peopleByName.get(name);
            if (personByName.getBirthDate() != null) {
                person.setBirthDate(personByName.getBirthDate());
            }
        }

        for (Person personByName : peopleByName.values()) {
            for (Person parent : personByName.getParents()) {
                if (name.equals(parent.getName())) {
                    person.addChild(personByName);
                }
            }

            for (Person child : personByName.getChildren()) {
                if (name.equals(child.getName())) {
                    person.addParent(personByName);
                }
            }
        }

        return person;
    }

    private static void fillMissingData() {
        for (Person person : peopleWithFullData) {

            String name = person.getName();
            Date birthDate = person.getBirthDate();

            if (peopleByName.containsKey(name)) {
                peopleByName.get(name).setBirthDate(birthDate);
            }

            if (peopleByDate.containsKey(birthDate)) {
                peopleByDate.get(birthDate).setName(name);
            }

            for (Person personByName : peopleByName.values()) {
                for (Person child : personByName.getChildren()) {
                    if (name.equals(child.getName())) {
                        child.setBirthDate(birthDate);
                    }

                    if (birthDate.equals(child.getBirthDate())) {
                        child.setName(name);
                    }
                }

                for (Person parent : personByName.getParents()) {
                    if (name.equals(parent.getName())) {
                        parent.setBirthDate(birthDate);
                    }

                    if (birthDate.equals(parent.getBirthDate())) {
                        parent.setName(name);
                    }
                }
            }

            for (Person personByDate : peopleByDate.values()) {
                for (Person child : personByDate.getChildren()) {
                    if (name.equals(child.getName())) {
                        child.setBirthDate(birthDate);
                    }

                    if (birthDate.equals(child.getBirthDate())) {
                        child.setName(name);
                    }
                }

                for (Person parent : personByDate.getParents()) {
                    if (name.equals(parent.getName())) {
                        parent.setBirthDate(birthDate);
                    }

                    if (birthDate.equals(parent.getBirthDate())) {
                        parent.setName(name);
                    }
                }
            }
        }
    }

    private static void addPersonWithFullData(String inputData) {

        String[] splitData = inputData.split("\\s+");

        String personName = splitData[0] + " " + splitData[1];
        String personBirthDateString = splitData[2];
        Date personBirthdate = convertToDate(personBirthDateString);

        Person person = new Person(personName, personBirthdate);

        peopleWithFullData.add(person);
    }

    private static Person createPerson(String personData) {
         if (isName(personData)) {
             String name = personData;
             Person person = new Person(name);
             peopleByName.put(name, person);
             return person;
         } else {
             Date birthDate = convertToDate(personData);
             Person person = new Person(birthDate);
             peopleByDate.put(birthDate, person);
             return person;
         }
    }

    private static boolean isName(String data){
        String name = "[A-Z][A-Za-z]+ [A-Z][A-Za-z]+";
        Pattern namePattern = Pattern.compile(name);
        Matcher nameMatcher = namePattern.matcher(data);

        return nameMatcher.find();
    }

    private static boolean isDate(String data){
        String date = "[0-9]{2}/[0-9]{2}/[0-9]{4}";
        Pattern datePattern = Pattern.compile(date);
        Matcher dateMatcher = datePattern.matcher(data);

        return dateMatcher.find();
    }

    private static Date convertToDate(String personInfo) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date birthDate;
        try {
            birthDate = df.parse(personInfo);
            return birthDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
