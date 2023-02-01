package net.ivanzykov.wordcounter;

import net.ivanzykov.wordcounter.consoleprinter.ConsolePrinterImpl;
import net.ivanzykov.wordcounter.runner.*;
import net.ivanzykov.wordcounter.stopwordsreader.StopWordsReaderImpl;
import net.ivanzykov.wordcounter.userinputreader.UserInputReaderImpl;
import net.ivanzykov.wordcounter.wordscounter.StopWordsReader;
import net.ivanzykov.wordcounter.wordscounter.UserInputReader;
import net.ivanzykov.wordcounter.wordscounter.WordsCounterImpl;

/**
 * Instantiates required classes and triggers the runner object.
 */
public class WordCounterApp {

    public static final String STOP_WORDS_FILENAME = "stopwords.txt";

    public static void main(final String[] args) {
        UserInputReader userInputReader = new UserInputReaderImpl();
        StopWordsReader stopWordsReader = new StopWordsReaderImpl();
        WordsCounter wordsCounter = new WordsCounterImpl(userInputReader, STOP_WORDS_FILENAME, stopWordsReader);
        ConsolePrinter consolePrinter = new ConsolePrinterImpl();

        new Runner(wordsCounter, consolePrinter).run();
    }
}
