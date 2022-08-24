import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


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
