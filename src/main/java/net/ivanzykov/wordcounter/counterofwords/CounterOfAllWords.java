package net.ivanzykov.wordcounter.counterofwords;

import net.ivanzykov.wordcounter.wordcount.Actor;
import net.ivanzykov.wordcounter.wordcount.FieldOfWordCountNullException;
import net.ivanzykov.wordcounter.wordcount.WordCount;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class CounterOfAllWords implements Actor {

    /**
     * Counts words in users input considering the stop words.
     *
     * @param wordCount wordCount object holding name of the file with stop words and for storing the result of this
     *                  method
     */
    @Override
    public void determineWordCount(WordCount wordCount) {
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
        List<String> words = new ArrayList<>();
        for (String word : usersInput.split("[^a-z,A-Z]+")) {
            if (Pattern.matches("[a-z,A-Z]+", word) && !stopWords.contains(word)) {
                words.add(word);
            }
        }
        wordCount.setCountOfWords(words.size());
    }
}
