package net.ivanzykov.wordcounter.runner;

import java.util.List;

/**
 * Controls execution flow of the app.
 */
public class Runner {

    private final WordsCounter wordsCounter;
    private final UserInputReader userInputReader;
    private final StopWordsReader stopWordsReader;
    private final ConsolePrinter consolePrinter;

    /**
     * Constructor for this class
     *
     * @param wordsCounter      wordsCounter object which counts words in the user's input
     * @param userInputReader   userInputReader object that reads user's input from console
     * @param consolePrinter    consolePrinter object that prints to the console
     * @param stopWordsReader   stopWordsReader object that reads stop words from a file
     */
    public Runner(WordsCounter wordsCounter, UserInputReader userInputReader, ConsolePrinter consolePrinter,
                  StopWordsReader stopWordsReader) {
        this.wordsCounter = wordsCounter;
        this.userInputReader = userInputReader;
        this.consolePrinter = consolePrinter;
        this.stopWordsReader = stopWordsReader;
    }

    public void run() {
        printToConsole("Enter text: ");

        String usersInput = readUsersInput();

        List<String> stopWords = null;
        try {
            stopWords = readStopWords();
        } catch (StopWordsReaderException e) {
            printToConsole(e.getLocalizedMessage());
            System.exit(-1);
        }

        printToConsole("Number of words: ");

        printToConsole(countWords(usersInput, stopWords));
    }

    private <T> void printToConsole(T text) {
        consolePrinter.print(text);
    }

    private String readUsersInput() {
        return userInputReader.read();
    }

    private List<String> readStopWords() {
        return stopWordsReader.read();
    }

    private int countWords(String usersInput, List<String> stopWords) {
        return wordsCounter.count(usersInput, stopWords);
    }
}
