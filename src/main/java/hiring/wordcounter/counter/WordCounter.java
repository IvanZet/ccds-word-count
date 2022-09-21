package hiring.wordcounter.counter;

import hiring.wordcounter.main.Counter;

import java.util.regex.Pattern;

public class WordCounter implements Counter {

    /**
     * Counts words in the provided text considering provided stop words
     *
     * @param text      string with words to count
     * @param stopWords string with stop words which should not be counted in the input text
     * @return          int of how many words found in the provided text
     */
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
