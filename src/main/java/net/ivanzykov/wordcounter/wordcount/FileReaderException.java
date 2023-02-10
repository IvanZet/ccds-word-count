package net.ivanzykov.wordcounter.wordcount;

/**
 * For errors while reading stop words.
 */
public class FileReaderException extends RuntimeException {

    public FileReaderException(String message) {
        super(message);
    }
}
