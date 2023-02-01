package net.ivanzykov.wordcounter.wordscounter;

import net.ivanzykov.wordcounter.runner.WordsCounter;

import java.util.List;
import java.util.regex.Pattern;

public class WordsCounterImpl implements WordsCounter {

    private final UserInputReader userInputReader;
    private final StopWordsReader stopWordsReader;

    /**
     * Constructor for this class.
     *
     * @param userInputReader userInputReader object that reads user's input from console
     * @param stopWordsReader stopWordsReader
     */
    public WordsCounterImpl(UserInputReader userInputReader, StopWordsReader stopWordsReader) {
        this.userInputReader = userInputReader;
        this.stopWordsReader = stopWordsReader;
    }

    /**
     * Counts words after getting user's input and stop words.
     *
     * @return int of how many words found in the user's input
     */
    @Override
    public int count() {
        int counter = 0;
        for (String word: readUsersInput().split(" ")) {
            if (Pattern.matches("[a-z,A-Z]+", word) && ! readStopWords().contains(word)) {
                counter++;
            }
        }
        return counter;
    }

    private String readUsersInput() {
        return userInputReader.read();
    }

    private List<String> readStopWords() {
        return stopWordsReader.read();
    }
}
