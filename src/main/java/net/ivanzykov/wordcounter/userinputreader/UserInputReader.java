package net.ivanzykov.wordcounter.userinputreader;

import net.ivanzykov.wordcounter.runner.Actor;
import net.ivanzykov.wordcounter.runner.ConsolePrinter;
import net.ivanzykov.wordcounter.runner.WordCount;

import java.util.Scanner;

public class UserInputReader implements Actor {

    private final ConsolePrinter consolePrinter;

    /**
     * Constructor for this class.
     *
     * @param consolePrinter    consolePrinter object that prints to the console
     */
    public UserInputReader(ConsolePrinter consolePrinter) {
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
