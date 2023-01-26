package net.ivanzykov.wordcounter.consoleprinter;

import net.ivanzykov.wordcounter.main.ConsolePrinter;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ConsolePrinterImplTest {

    @Test
    void write() {
        // Intercept output to the console
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ConsolePrinter consolePrinter = new ConsolePrinterImpl();
        String text = "a 2";
        consolePrinter.write(text);

        assertTrue(outContent.toString().contains(text));
    }
}