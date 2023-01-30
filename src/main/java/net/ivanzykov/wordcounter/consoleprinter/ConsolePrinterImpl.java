package net.ivanzykov.wordcounter.consoleprinter;

import net.ivanzykov.wordcounter.runner.ConsolePrinter;

public class ConsolePrinterImpl implements ConsolePrinter {

    /**
     * Prints provided value to the console.
     *
     * @param value  value which is printed to the console
     */
    @Override
    public <T> void print(T value) {
        System.out.print(value);
    }
}
