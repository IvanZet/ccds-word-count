package net.ivanzykov.wordcounter.runner;

/**
 * Controls execution flow of the app.
 */
public class Runner {

    private final WordsCounter wordsCounter;
    private final ConsolePrinter consolePrinter;

    /**
     * Constructor for this class
     *
     * @param wordsCounter   wordsCounter object which counts words in the user's input
     * @param consolePrinter consolePrinter object that prints to the console
     */
    public Runner(WordsCounter wordsCounter, ConsolePrinter consolePrinter) {
        this.wordsCounter = wordsCounter;
        this.consolePrinter = consolePrinter;
    }

    public void run() {
        printToConsole("Enter text: ");

        int countOfWords = 0;
        try {
            countOfWords = countWords();
        } catch (StopWordsReaderException e) {
            printToConsole(e.getLocalizedMessage());
            System.exit(-1);
        }

        printToConsole("Number of words: ");

        printToConsole(countOfWords);
    }

    private <T> void printToConsole(T text) {
        consolePrinter.print(text);
    }

    private int countWords() {
        return wordsCounter.count();
    }
}
