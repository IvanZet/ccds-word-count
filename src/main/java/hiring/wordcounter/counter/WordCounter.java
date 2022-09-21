package hiring.wordcounter.counter;

import hiring.wordcounter.main.Counter;

import java.util.regex.Pattern;

public class WordCounter implements Counter {
    @Override
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
