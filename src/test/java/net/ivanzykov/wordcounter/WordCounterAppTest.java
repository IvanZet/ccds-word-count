package net.ivanzykov.wordcounter;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterAppTest {

    @Test
    void main() {
        // Prepare user's input
        InputStream standardIn = System.in;
        System.setIn(new ByteArrayInputStream("abc".getBytes()));

        // Capture printing to console
        PrintStream standardOut = System.out;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // Run this test
        WordCounterApp.main(new String[]{});

        assertEquals("Enter text: Number of words: 1", outputStreamCaptor.toString().trim());

        // Restore standard in and out
        System.setIn(standardIn);
        System.setOut(standardOut);
    }
}
