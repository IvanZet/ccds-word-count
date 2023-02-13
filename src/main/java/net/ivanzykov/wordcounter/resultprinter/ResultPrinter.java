package net.ivanzykov.wordcounter.resultprinter;

import net.ivanzykov.wordcounter.wordcount.Actor;
import net.ivanzykov.wordcounter.wordcount.ConsolePrinter;
import net.ivanzykov.wordcounter.wordcount.FieldOfWordCountNullException;
import net.ivanzykov.wordcounter.wordcount.WordCount;

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
     * Gets count of all and uniques words and prints them to console.
     *
     * @param wordCount wordCount object holding count of all words and count of unique words
     */
    @Override
    public void determineWordCount(WordCount wordCount) {
        printToConsole("Number of words: ");
        try {
            printToConsole(Objects.requireNonNull(wordCount.getCountOfAllWords()));
        } catch (NullPointerException e) {
            throw new FieldOfWordCountNullException("Can't print count of all words. It is null in the WordCount" +
                    " object");
        }
        printToConsole(", unique: ");
        try {
            printToConsole(Objects.requireNonNull(wordCount.getCountOfUniqueWords()));
        } catch (NullPointerException e) {
            throw new FieldOfWordCountNullException("Can't print count of unique words. It is null in the WordCount" +
                    " object");
        }
    }

    private <T> void printToConsole(T count) {
        consolePrinter.print(count);
    }
}
