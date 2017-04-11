package Problem_06_StategyPattern;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {

    @Override
    public int compare(Person firstPerson, Person secondPerson) {

        int firstPersonNameLength = firstPerson.getName().length();
        int secondPersonNameLength = secondPerson.getName().length();
        int nameLengthComparator = firstPersonNameLength - secondPersonNameLength;

        char firstPersonStartLetter = this.firstLetter(firstPerson);
        char secondPersonStartLetter = this.firstLetter(secondPerson);
        int firstLetterComparator = firstPersonStartLetter - secondPersonStartLetter;

        if (nameLengthComparator == 0) {
            return firstLetterComparator;
        }

        return nameLengthComparator;
    }

    private char firstLetter(Person person){
        String name = person.getName();
        String nameToLowerCase = name.toLowerCase();
        char startLetter = nameToLowerCase.charAt(0);
        return startLetter;
    }
}
