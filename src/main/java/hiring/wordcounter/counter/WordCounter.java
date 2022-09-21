package hiring.wordcounter.counter;

import hiring.wordcounter.main.Counter;

import java.util.regex.Pattern;

public class WordCounter implements Counter {
    @Override
    public int count(String text, String stopWords) {
        int counter = 0;
        for (String word: text.split(" ")) {
            if (Pattern.matches("[a-z,A-Z]+", word) && ! stopWords.contains(word)) {
                counter++;
            }
        }
        return counter;
    }
}
