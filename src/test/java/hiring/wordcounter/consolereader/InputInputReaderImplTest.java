package hiring.wordcounter.consolereader;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class InputInputReaderImplTest {

    private static ByteArrayOutputStream outContent;

    @BeforeAll
    static void initAll() {
        // Overtake printing to the console
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void read_consoleInput_returnText() {
        InputInputReaderImpl inputReaderImpl = new InputInputReaderImpl();

        // Mock input
        String input = "a";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        assertEquals(input, inputReaderImpl.read());
        assertTrue(outContent.toString().contains("Enter text:"));
    }
}