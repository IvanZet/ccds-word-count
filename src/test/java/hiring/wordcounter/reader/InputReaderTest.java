package hiring.wordcounter.reader;

import hiring.wordcounter.counter.WordCounter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class InputReaderTest {

    private static ByteArrayOutputStream outContent;

    @BeforeAll
    static void initAll() {
        // Overtake printing to the console
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void read_consoleInput_returnText() {
        Counter counter = new WordCounter();
        InputReader inputReader = new InputReader(counter);

        // Mock input
        String input = "a";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        assertEquals(input, inputReader.read());
        assertTrue(outContent.toString().contains("Enter text:"));
    }
}