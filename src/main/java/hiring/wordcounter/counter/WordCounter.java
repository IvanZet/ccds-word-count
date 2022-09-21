package hiring.wordcounter.counter;

import hiring.wordcounter.reader.Counter;

import java.util.regex.Pattern;

public class WordCounter implements Counter {
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
