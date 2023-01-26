package net.ivanzykov.wordcounter.main;

import net.ivanzykov.wordcounter.wordscounter.WordsCounterImpl;
import net.ivanzykov.wordcounter.userinputreader.UserInputReaderImpl;
import net.ivanzykov.wordcounter.stopwordsreader.StopWordsReaderImpl;
import net.ivanzykov.wordcounter.consoleprinter.ConsolePrinterImpl;

/**
 * The main class stat instantiates all dependencies and runs the app
 */
public class Main {

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
    public Main (WordsCounter wordsCounter, UserInputReader userInputReader, ConsolePrinter consolePrinter,
                 StopWordsReader stopWordsReader) {
        this.wordsCounter = wordsCounter;
        this.userInputReader = userInputReader;
        this.consolePrinter = consolePrinter;
        this.stopWordsReader = stopWordsReader;
    }

    /**
     * Starts this app
     */
    public void run() {
        // TODO: move conversion of result of wordsCounter.count() to WordsCounter
        consolePrinter.write(String.valueOf(wordsCounter.count(userInputReader.read(), stopWordsReader.read())));
    }

    public static void main(final String[] args) {
        WordsCounter wordsCounter = new WordsCounterImpl();
        UserInputReader userInputReader = new UserInputReaderImpl();
        ConsolePrinter consolePrinter = new ConsolePrinterImpl();
        StopWordsReader stopWordsReader = new StopWordsReaderImpl();

        new Main(wordsCounter, userInputReader, consolePrinter, stopWordsReader).run();
    }
}
