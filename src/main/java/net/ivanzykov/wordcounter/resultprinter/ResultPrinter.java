package net.ivanzykov.wordcounter.resultprinter;

import net.ivanzykov.wordcounter.runner.Actor;
import net.ivanzykov.wordcounter.runner.ConsolePrinter;
import net.ivanzykov.wordcounter.runner.FieldOfWordCountNullException;
import net.ivanzykov.wordcounter.runner.WordCount;

import java.util.Objects;

public class ResultPrinter implements Actor {

    private final ConsolePrinter consolePrinter;

    /**
     * Constructor of this class.
     *
     * @param consolePrinter    consolePrinter object that prints to the console
     */
    public ResultPrinter(ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    /**
     * @param wordCount wordCount object holding name of the file with stop words and for storing the result of this
     *                  method
     */
    @Override
    public void determineWordCount(WordCount wordCount) {
        printToConsole("Number of words: ");
        try {
            printToConsole(Objects.requireNonNull(wordCount.getCountOfWords()));
        } catch (NullPointerException e) {
            throw new FieldOfWordCountNullException("Can't print count of words. It is null in the WordCount object");
        }
    }

    private <T> void printToConsole(T count) {
        consolePrinter.print(count);
    }
}
