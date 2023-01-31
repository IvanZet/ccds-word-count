package net.ivanzykov.wordcounter.runner;

/**
 * For errors while reading stop words.
 */
public class StopWordsReaderException extends RuntimeException {

    public StopWordsReaderException (String message) {
        super(message);
    }
}
