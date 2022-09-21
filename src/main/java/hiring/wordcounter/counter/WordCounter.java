package hiring.wordcounter.counter;

import java.util.regex.Pattern;

public class WordCounter {
    public int count(String text) {
        int counter = 0;
        for (String word: text.split(" ")) {
            if (Pattern.matches("[a-z,A-Z]+", word)) {
                counter++;
            }
        }
        return counter;
    }
}
