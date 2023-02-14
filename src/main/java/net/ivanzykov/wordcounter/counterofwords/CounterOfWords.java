package net.ivanzykov.wordcounter.counterofwords;

import net.ivanzykov.wordcounter.wordcount.Actor;
import net.ivanzykov.wordcounter.wordcount.FieldOfWordCountNullException;
import net.ivanzykov.wordcounter.wordcount.WordCount;

import java.util.*;

public class CounterOfWords implements Actor {

    /**
     * Counts all and unique words in users input considering the stop words.
     *
     * @param wordCount wordCount object holding user's input and stop words and for storing the result of this method
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
        List<String> allWords = new ArrayList<>();
        Set<String> uniqueWords = new HashSet<>();
        for (String word : usersInput.split("[^a-z,A-Z]+")) {
            if (!stopWords.contains(word)) {
                allWords.add(word);
                uniqueWords.add(word);
            }
        }
        wordCount.setCountOfAllWords(allWords.size());
        wordCount.setCountOfUniqueWords(uniqueWords.size());
    }
}
