package net.ivanzykov.wordcounter.resultprinter;

import net.ivanzykov.wordcounter.App;
import net.ivanzykov.wordcounter.consoleprinter.ConsolePrinterImpl;
import net.ivanzykov.wordcounter.wordcount.Actor;
import net.ivanzykov.wordcounter.wordcount.ConsolePrinter;
import net.ivanzykov.wordcounter.wordcount.FieldOfWordCountNullException;
import net.ivanzykov.wordcounter.wordcount.WordCount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ResultPrinterTest {

    private PrintStream standardOut;
    private ByteArrayOutputStream outputStreamCaptor;
    private WordCount wordCount;
    private Actor resultPrinter;

    @BeforeEach
    void setUp() {
        wordCount = new WordCount(App.STOP_WORDS_FILENAME, null);

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
        wordCount.setCountOfAllWords(2);
        wordCount.setCountOfUniqueWords(1);

        resultPrinter.determineWordCount(wordCount);

        assertEquals("Number of words: 2, unique: 1", outputStreamCaptor.toString().trim());
    }

    @Test
    void determineWordCount_nullCountOfAllWords_throwsException() {
        Exception exception = assertThrows(FieldOfWordCountNullException.class, () ->
                resultPrinter.determineWordCount(wordCount));

        assertEquals("Can't print count of all words. It is null in the WordCount object",
                exception.getMessage());
    }

    @Test
    void determineWordCount_nullCountOfUniqueWords_throwsException() {
        wordCount.setCountOfAllWords(2);
        Exception exception = assertThrows(FieldOfWordCountNullException.class, () ->
                resultPrinter.determineWordCount(wordCount));

        assertEquals("Can't print count of unique words. It is null in the WordCount object",
                exception.getMessage());
    }
}
