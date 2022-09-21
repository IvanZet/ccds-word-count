package hiring.wordcounter.main;

/**
 * For classes counting words
 */
public interface Counter {
    int count(String text, String stopWords);
}
