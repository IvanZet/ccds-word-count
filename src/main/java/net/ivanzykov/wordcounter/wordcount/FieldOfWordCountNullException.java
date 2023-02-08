package net.ivanzykov.wordcounter.wordcount;

/**
 * For cases when a requested field in {@link WordCount} is null.
 */
public class FieldOfWordCountNullException extends RuntimeException {
    public FieldOfWordCountNullException(String message) {
        super(message);
    }
}
