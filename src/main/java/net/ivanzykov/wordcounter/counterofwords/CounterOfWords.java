package net.ivanzykov.wordcounter.counterofwords;

import net.ivanzykov.wordcounter.runner.Actor;
import net.ivanzykov.wordcounter.runner.WordCount;

import java.util.regex.Pattern;

public class CounterOfWords implements Actor {

    /**
     * Counts words in users input considering the stop words.
     *
     * @param wordCount wordCount object holding name of the file with stop words and for storing the result of this
     *                  method
     */
    @Override
    public void determineWordCount(WordCount wordCount) {
        Integer counter = 0;
        for (String word: wordCount.getUsersInput().split(" ")) {
            if (Pattern.matches("[a-z,A-Z]+", word) && ! wordCount.getStopWords().contains(word)) {
                counter++;
            }
        }
        wordCount.setCountOfWords(counter);
    }
}
