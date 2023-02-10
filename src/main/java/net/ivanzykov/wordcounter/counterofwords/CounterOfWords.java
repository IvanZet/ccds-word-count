package net.ivanzykov.wordcounter.counterofwords;

import net.ivanzykov.wordcounter.wordcount.FieldOfWordCountNullException;
import net.ivanzykov.wordcounter.wordcount.WordCount;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * For classes counting words in user's input considering stop words.
 */
public interface CounterOfWords {
    String ERROR_MESSAGE_START = "Failed to count words. ";
    String ERROR_MESSAGE_END = "is null in WordCount object";

    /**
     * Gets user's input and stop words from {@link WordCount} object, identifies words and adds them to the supplied
     * collection.
     *
     * @param collection collection object of Strings where identified words should be stored
     * @param wordCount  wordCount object holding user's input and stop words
     */
    default void collectWords(Collection<String> collection, WordCount wordCount) {
        String usersInput;
        try {
            usersInput = Objects.requireNonNull(wordCount.getUsersInput());
        } catch (NullPointerException e) {
            throw new FieldOfWordCountNullException(ERROR_MESSAGE_START + "User's input " + ERROR_MESSAGE_END);
        }

        List<String> stopWords;
        try {
            stopWords = Objects.requireNonNull(wordCount.getStopWords());
        } catch (NullPointerException e) {
            throw new FieldOfWordCountNullException(ERROR_MESSAGE_START + "Stop words " + ERROR_MESSAGE_END);
        }

        for (String word : usersInput.split("[^a-z,A-Z]+")) {
            if (Pattern.matches("[a-z,A-Z]+", word) && !stopWords.contains(word)) {
                collection.add(word);
            }
        }
    }
}
