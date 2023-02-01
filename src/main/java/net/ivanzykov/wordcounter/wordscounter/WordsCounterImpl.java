package net.ivanzykov.wordcounter.wordscounter;

import net.ivanzykov.wordcounter.runner.WordsCounter;

import java.util.List;
import java.util.regex.Pattern;

public class WordsCounterImpl implements WordsCounter {

    private final UserInputReader userInputReader;
    private String stopWordsFilename;
    private final StopWordsReader stopWordsReader;

    /**
     * Constructor for this class.
     *
     * @param userInputReader   userInputReader object that reads user's input from console
     * @param stopWordsFilename string with the name of the file with stop words
     * @param stopWordsReader   stopWordsReader
     */
    public WordsCounterImpl(UserInputReader userInputReader, String stopWordsFilename, StopWordsReader stopWordsReader) {
        this.userInputReader = userInputReader;
        this.stopWordsFilename = stopWordsFilename;
        this.stopWordsReader = stopWordsReader;
    }

    /**
     * Counts words in the provided text considering provided stop words
     *
     * @return int of how many words found in the provided text
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
        return stopWordsReader.read(stopWordsFilename);
    }
}
