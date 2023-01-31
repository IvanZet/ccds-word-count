package net.ivanzykov.wordcounter.runner;

import java.util.List;

/**
 * For classes counting words
 */
public interface WordsCounter {
    int count(String text, List<String> stopWords);
}
