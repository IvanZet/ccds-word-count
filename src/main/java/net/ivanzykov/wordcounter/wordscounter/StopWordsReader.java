package net.ivanzykov.wordcounter.wordscounter;

import java.util.List;

/**
 * For classes reading stop words
 */
public interface StopWordsReader {
    List<String> read();
}
