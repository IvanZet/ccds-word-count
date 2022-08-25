import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Class to count words in text.
 */
public class WordCount {


    private final static Pattern pattern = Pattern.compile("[a-zA-Z]+");


    /**
     * Counts words containing only (a-z,A-Z) (non unique) split by whitespace.
     *
     * @param text text to counts words in
     * @return number of words as described above
     */
    public long countWords(final String text) {
        if (text == null) {
            throw new IllegalArgumentException("Null can not be tested for word count.");
        }
        String[] words = text.split("\\s");
        return Arrays.stream(words)
                .filter(w -> pattern.matcher(w).matches())
                .count();

    }

}
