package net.ivanzykov.wordcounter;

import net.ivanzykov.wordcounter.consoleprinter.ConsolePrinterImpl;
import net.ivanzykov.wordcounter.counterofwords.CounterOfWords;
import net.ivanzykov.wordcounter.resultprinter.ResultPrinter;
import net.ivanzykov.wordcounter.wordcount.*;
import net.ivanzykov.wordcounter.stopwordsreader.StopWordsReader;
import net.ivanzykov.wordcounter.userinputreader.UserInputConsoleReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Instantiates required classes and runs this app.
 */
public class App {

    public static final String STOP_WORDS_FILENAME = "stopwords.txt";

    public static void main(final String[] args) {

        ConsolePrinter consolePrinter = new ConsolePrinterImpl();

        List<Actor> actors = new ArrayList<>(Arrays.asList(
                new StopWordsReader(),
                new UserInputConsoleReader(consolePrinter),
                new CounterOfWords(),
                new ResultPrinter(consolePrinter)));

        new WordCount(STOP_WORDS_FILENAME, actors, consolePrinter).count();
    }
}
