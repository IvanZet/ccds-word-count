package net.ivanzykov.wordcounter.userinputreader;

import net.ivanzykov.wordcounter.WordCounterApp;
import net.ivanzykov.wordcounter.consoleprinter.ConsolePrinterImpl;
import net.ivanzykov.wordcounter.runner.ConsolePrinter;
import net.ivanzykov.wordcounter.runner.WordCount;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class UserInputReaderTest {

    @Test
    void determineWordCount_printsTextToConsoleAndSetsUsersInput() {
        // Simulate user's console input
        InputStream standardIn = System.in;
        System.setIn(new ByteArrayInputStream("abc".getBytes()));

        // Capture output to console
        PrintStream standardOut = System.out;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStreamCaptor);
        System.setOut(printStream);

        // Prepare args
        WordCount wordCount = new WordCount(WordCounterApp.STOP_WORDS_FILENAME, null, null);
        ConsolePrinter consolePrinter = new ConsolePrinterImpl();

        // Check blanc state before this test
        assertNull(wordCount.getUsersInput());

        // Run this test
        new UserInputReader(consolePrinter).determineWordCount(wordCount);

        assertAll(
                () -> assertEquals("Enter text: ", outputStreamCaptor.toString()),
                () -> assertEquals("abc", wordCount.getUsersInput())
        );

        // Restore standard in and out
        System.setIn(standardIn);
        System.setOut(standardOut);
    }
}