package net.ivanzykov.wordcounter.counterofwords;

import net.ivanzykov.wordcounter.wordcount.Actor;
import net.ivanzykov.wordcounter.wordcount.WordCount;

import java.util.HashSet;
import java.util.Set;

public class CounterOfUniqueWords implements Actor, CounterOfWords {

    /**
     * Counts unique words in users input considering the stop words.
     *
     * @param wordCount wordCount object holding user's input and stop words and for storing the result of this method
     */
    @Override
    public void determineWordCount(WordCount wordCount) {
        Set<String> uniqueWords = new HashSet<>();
        collectWords(uniqueWords, wordCount);
        wordCount.setCountOfUniqueWords(uniqueWords.size());
    }
}
