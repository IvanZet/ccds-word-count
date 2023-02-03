package net.ivanzykov.wordcounter;

import net.ivanzykov.wordcounter.consoleprinter.ConsolePrinterImpl;
import net.ivanzykov.wordcounter.runner.*;
import net.ivanzykov.wordcounter.stopwordsreader.StopWordsReaderImpl;
import net.ivanzykov.wordcounter.userinputreader.UserInputReaderImpl;
import net.ivanzykov.wordcounter.wordscounter.WordsCounterImpl;

/**
 * Instantiates required classes and triggers the runner object.
 */
public class WordCounterApp {

    public static final String STOP_WORDS_FILENAME = "stopwords.txt";

    public static void main(final String[] args) {
        WordsCounter wordsCounter = new WordsCounterImpl();
        UserInputReader userInputReader = new UserInputReaderImpl();
        ConsolePrinter consolePrinter = new ConsolePrinterImpl();
        StopWordsReader stopWordsReader = new StopWordsReaderImpl();

        new Runner(wordsCounter, userInputReader, consolePrinter, stopWordsReader).run();
    }
}
