import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCount {


    private final static Pattern pattern = Pattern.compile("\\s[a-z]+\\s");


    /**
     * Counts words containing only (a-z,A-Z) (non unique) split by whitespace.
     *
     * @param text text to counts words in
     * @return number of words as described above
     */
    public int countWords(final String text) {
        if (text == null) {
            throw new IllegalArgumentException("Null can not be tested for word count.");
        }
        final Matcher matcher = pattern.matcher(" " + text + " ");
        int count = 0;
        while (matcher.find())
            count++;
        return count;
    }


    public static void main(final String[] args) {

        try (final BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in))) {
            final WordCount wc = new WordCount();
            System.out.print("Enter text: ");
            String text = buffReader.readLine();
            System.out.print("Number of words: " + wc.countWords(text));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
