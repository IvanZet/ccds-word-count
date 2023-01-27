package net.ivanzykov.wordcounter.userinputreader;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class UserInputReaderImplTest {

    private static ByteArrayOutputStream outContent;

    @BeforeAll
    static void initAll() {
        // Overtake printing to the console
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void read_consoleInput_returnText() {
        UserInputReaderImpl inputReaderImpl = new UserInputReaderImpl();

        // Mock input
        String input = "a";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        assertEquals(input, inputReaderImpl.read());
    }
}