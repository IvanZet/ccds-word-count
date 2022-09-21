package hiring.wordcounter.writer;

import hiring.wordcounter.main.Writer;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleWriterTest {

    @Test
    void write() {
        // Intercept output to the console
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Writer writer = new ConsoleWriter();
        String text = "a 2";
        writer.write(text);

        assertTrue(outContent.toString().contains(text));
    }
}