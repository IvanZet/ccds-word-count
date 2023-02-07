package net.ivanzykov.wordcounter.resultprinter;

import net.ivanzykov.wordcounter.WordCounterApp;
import net.ivanzykov.wordcounter.consoleprinter.ConsolePrinterImpl;
import net.ivanzykov.wordcounter.runner.Actor;
import net.ivanzykov.wordcounter.runner.ConsolePrinter;
import net.ivanzykov.wordcounter.runner.FieldOfWordCountNullException;
import net.ivanzykov.wordcounter.runner.WordCount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ResultPrinterTest {

    private PrintStream standardOut;
    private ByteArrayOutputStream outputStreamCaptor;
    private WordCount wordCount;
    private Actor resultPrinter;

    @BeforeEach
    void setUp() {
        wordCount = new WordCount(WordCounterApp.STOP_WORDS_FILENAME, null);

        // Capture output to console
        standardOut = System.out;
        outputStreamCaptor = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStreamCaptor);
        System.setOut(printStream);

        ConsolePrinter consolePrinter = new ConsolePrinterImpl();
        resultPrinter = new ResultPrinter(consolePrinter);
    }

    @AfterEach
    void tearDown() {
        // Restore standard out
        System.setOut(standardOut);
    }

    @Test
    void determineWordCount_printsToConsole() {
        wordCount.setCountOfWords(1);

        resultPrinter.determineWordCount(wordCount);

        assertEquals("Number of words: 1", outputStreamCaptor.toString().trim());
    }

    @Test
    void determineWordCount_nullCountOfWords_throwsException() {
        Exception exception = assertThrows(FieldOfWordCountNullException.class, () ->
                resultPrinter.determineWordCount(wordCount));

        assertTrue(exception.getMessage().contains("Can't print count of words. It is null in the WordCount object"));
    }
}
