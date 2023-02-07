package net.ivanzykov.wordcounter.counterofwords;

import net.ivanzykov.wordcounter.runner.Actor;
import net.ivanzykov.wordcounter.runner.FieldOfWordCountNullException;
import net.ivanzykov.wordcounter.runner.WordCount;

import java.util.List;
import java.util.Objects;
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
        String errorMessageStart = "Failed to count words. ";
        String errorMessageEnd = "is null in WordCount object";
        String usersInput;
        try {
            usersInput = Objects.requireNonNull(wordCount.getUsersInput());
        } catch (NullPointerException e) {
            throw new FieldOfWordCountNullException(errorMessageStart + "User's input " + errorMessageEnd);
        }
        List<String> stopWords;
        try {
            stopWords = Objects.requireNonNull(wordCount.getStopWords());
        } catch (NullPointerException e) {
            throw new FieldOfWordCountNullException(errorMessageStart + "Stop words " + errorMessageEnd);
        }
        for (String word: usersInput.split(" ")) {
            if (Pattern.matches("[a-z,A-Z]+", word) && ! stopWords.contains(word)) {
                counter++;
            }
        }
        wordCount.setCountOfWords(counter);
    }
}
