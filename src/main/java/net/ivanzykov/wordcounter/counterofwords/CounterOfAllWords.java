package net.ivanzykov.wordcounter.counterofwords;

import net.ivanzykov.wordcounter.wordcount.Actor;
import net.ivanzykov.wordcounter.wordcount.WordCount;

import java.util.ArrayList;
import java.util.List;

public class CounterOfAllWords implements Actor, CounterOfWords {

    /**
     * Counts all words in users input considering the stop words.
     *
     * @param wordCount wordCount object holding user's input and stop words and for storing the result of this method
     */
    @Override
    public void determineWordCount(WordCount wordCount) {
        List<String> allWords = new ArrayList<>();
        collectWords(allWords, wordCount);
        wordCount.setCountOfAllWords(allWords.size());
    }
}
