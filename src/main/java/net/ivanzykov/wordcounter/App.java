package net.ivanzykov.wordcounter;

import net.ivanzykov.wordcounter.consoleprinter.ConsolePrinterImpl;
import net.ivanzykov.wordcounter.counterofwords.CounterOfWords;
import net.ivanzykov.wordcounter.resultprinter.ResultPrinter;
import net.ivanzykov.wordcounter.stopwordsreader.StopWordsReader;
import net.ivanzykov.wordcounter.userinputreader.UserInputFactory;
import net.ivanzykov.wordcounter.wordcount.Actor;
import net.ivanzykov.wordcounter.wordcount.ConsolePrinter;
import net.ivanzykov.wordcounter.wordcount.CriticalAppException;
import net.ivanzykov.wordcounter.wordcount.WordCount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Instantiates required classes and runs this app.
 */
public class App {

    public static final String STOP_WORDS_FILENAME = "stopwords.txt";

    public static void main(final String[] args) {

        if (args.length > 1) {
            throw new CriticalAppException("Wrong number of arguments. Only one is supported.");
        }

        String usersInputFilename = null;
        if (args.length > 0) {
            usersInputFilename = args[0];
        }

        ConsolePrinter consolePrinter = new ConsolePrinterImpl();

        Actor userInputReader = UserInputFactory.createUserInputReader(usersInputFilename, consolePrinter);

        List<Actor> actors = new ArrayList<>(Arrays.asList(
                new StopWordsReader(),
                userInputReader,
                new CounterOfWords(),
                new ResultPrinter(consolePrinter)));

        new WordCount(STOP_WORDS_FILENAME, actors).count();
    }
}
