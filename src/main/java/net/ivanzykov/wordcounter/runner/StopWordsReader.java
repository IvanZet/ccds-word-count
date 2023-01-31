package net.ivanzykov.wordcounter.runner;

import java.util.List;

/**
 * For classes reading stop words
 */
public interface StopWordsReader {
    List<String> read();
}
