package net.ivanzykov.wordcounter.userinputreader;

import net.ivanzykov.wordcounter.wordcount.Actor;
import net.ivanzykov.wordcounter.wordcount.ConsolePrinter;
import net.ivanzykov.wordcounter.wordcount.WordCount;

import java.util.Scanner;

public class UserInputConsoleReader implements Actor {

    private final ConsolePrinter consolePrinter;

    /**
     * Constructor for this class.
     *
     * @param consolePrinter    consolePrinter object that prints to the console
     */
    public UserInputConsoleReader(ConsolePrinter consolePrinter) {
        this.consolePrinter = consolePrinter;
    }

    /**
     * Reads user's input from the console
     *
     * @param wordCount wordCount object holding name of the file with stop words and for storing the result of this
     *                  method
     */
    @Override
    public void determineWordCount(WordCount wordCount) {
        printEnterTextToConsole();

        try (Scanner scanner = new Scanner(System.in)) {
            wordCount.setUsersInput(scanner.nextLine());
        }
    }

    private void printEnterTextToConsole() {
        consolePrinter.print("Enter text: ");
    }
}
