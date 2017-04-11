package Problem_04_Telephony;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Smartphone implements Callable, Browsable{

    @Override
    public void call(String number) {

        boolean numberContainsCharacter = this.validateNumber(number);

        if (numberContainsCharacter) {
            throw new IllegalArgumentException("Invalid number!");
        }

        String output = String.format("Calling... %s", number);
        System.out.println(output);
    }

    @Override
    public void browse(String website) {

        boolean websiteContainsDigit = this.validateWebsite(website);

        if (websiteContainsDigit) {
            throw new IllegalArgumentException("Invalid URL!");
        }

        String output = String.format("Browsing: %s!", website);
        System.out.println(output);
    }

    private boolean validateNumber(String number) {

        String pattern = "\\D";

        Pattern numberPattern = Pattern.compile(pattern);

        Matcher matcher = numberPattern.matcher(number);

        return matcher.find();
    }

    private boolean validateWebsite(String website) {
        String pattern = "\\d";

        Pattern websitePattern = Pattern.compile(pattern);

        Matcher matcher = websitePattern.matcher(website);

        return matcher.find();
    }
}
