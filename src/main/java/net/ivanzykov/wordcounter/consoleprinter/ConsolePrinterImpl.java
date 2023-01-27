package net.ivanzykov.wordcounter.consoleprinter;

import net.ivanzykov.wordcounter.main.ConsolePrinter;

public class ConsolePrinterImpl implements ConsolePrinter {

    /**
     * Prints provided text to the console.
     *
     * @param text  string which is printed to the console
     */
    @Override
    public void print(String text) {
        System.out.print(text);
    }
}
