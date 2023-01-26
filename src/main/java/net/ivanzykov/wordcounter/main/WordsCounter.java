package net.ivanzykov.wordcounter.main;

/**
 * For classes counting words
 */
public interface WordsCounter {
    int count(String text, String stopWords);
}
