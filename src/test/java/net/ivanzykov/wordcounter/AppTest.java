package net.ivanzykov.wordcounter;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AppTest {

    @Test
    void main_countsOneWord() {
        // Prepare user's input
        InputStream standardIn = System.in;
        String usersInput = "abc";
        InputStream inputStream = new ByteArrayInputStream(usersInput.getBytes());
        System.setIn(inputStream);

        // Capture printing to console
        PrintStream standardOut = System.out;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStreamCaptor);
        System.setOut(printStream);

        // Run this test
        App.main(new String[]{});

        assertEquals("Enter text: Number of words: 1", outputStreamCaptor.toString().trim());

        // Restore standard in and out
        System.setIn(standardIn);
        System.setOut(standardOut);
    }

    @Test
    void main_twoArguments_throwsException() {
        Exception exception = assertThrows(CriticalAppException.class, () ->
                App.main(new String[]{"one", "two"}));

        assertEquals("Wrong number of arguments. Only one is supported.",
                exception.getMessage());
    }
}
