import java.io.*;
import java.util.*;

public class P06WordCount {

    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/resources/";
    private static final String WORDS_FILE_PATH = PROJECT_PATH + "words.txt";
    private static final String TEXT_FILE_PATH = PROJECT_PATH + "text.txt";
    private static final String RESULT_FILE_PATH = PROJECT_PATH + "results.txt";

    public static void main(String[] args) {

        Map<String, Integer> words = new HashMap<>();
        Set<String> wordsSet = new HashSet<>();

        try(BufferedReader textReader = new BufferedReader(new FileReader(TEXT_FILE_PATH));
            BufferedReader wordsReader = new BufferedReader(new FileReader(WORDS_FILE_PATH));
            PrintWriter writer = new PrintWriter(new FileOutputStream(RESULT_FILE_PATH)))
        {
           String line = "";
            while((line = wordsReader.readLine()) != null){
                String[] wordsArr = line.split("\\s+");

                for (String word:wordsArr) {
                    wordsSet.add(word);
                }
            }

            for (String word: wordsSet){
                words.put(word, 0);
            }

            String t = textReader.readLine();
            while(t != null){

                String[] textLine = t.split("[\\p{Punct}\\s]+");
                boolean isCounted = false;

                for (String word: textLine){
                    for(String wordSet: wordsSet){
                        if(wordSet.toLowerCase().equals(word.toLowerCase())){
                            words.put(wordSet, words.get(wordSet) + 1);
                            isCounted = true;
                            break;
                        }
                    }
                    if(isCounted) break;
                }

                t = textReader.readLine();
            }

            words.entrySet().stream()
                    .sorted((w1, w2) -> w2.getValue().compareTo(w1.getValue()))
                    .forEach(w -> writer.println(w.getKey() + " - " + w.getValue()));

        }
        catch (Exception ex){
            System.out.println(ex.toString());
        }
    }
}
