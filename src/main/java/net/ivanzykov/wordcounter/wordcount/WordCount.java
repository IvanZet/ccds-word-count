package net.ivanzykov.wordcounter.wordcount;

import java.util.List;

/**
 * Holds data needed to determine word count in the user's input considering stop words, and calls components of this
 * app.
 */
public class WordCount {

    private List<String> stopWords;
    private final String stopWordsFileName;
    private String usersInput;
    private Integer countOfWords;
    private final List<Actor> actors;
    private final ConsolePrinter consolePrinter;

    /**
     * Constructor of this class.
     *
     * @param stopWordsFileName string with the name of the file with stop words
     * @param actors            list of actor objects that do their part of the job to determine the count of words
     * @param consolePrinter    consolePrinter object that prints supplied objects to the console
     */
    public WordCount(String stopWordsFileName, List<Actor> actors, ConsolePrinter consolePrinter) {
        this.stopWordsFileName = stopWordsFileName;
        this.actors = actors;
        this.consolePrinter = consolePrinter;
    }

    public List<String> getStopWords() {
        return stopWords;
    }

    public void setStopWords(List<String> stopWords) {
        this.stopWords = stopWords;
    }

    public String getStopWordsFileName() {
        return stopWordsFileName;
    }

    public String getUsersInput() {
        return usersInput;
    }

    public void setUsersInput(String usersInput) {
        this.usersInput = usersInput;
    }

    public Integer getCountOfWords() {
        return countOfWords;
    }

    public void setCountOfWords(Integer countOfWords) {
        this.countOfWords = countOfWords;
    }

    /**
     * Calls components of this app to determine the count of words in user's input and handles exceptions.
     */
    public void count() {
        try {
            for (Actor actor: actors) {
                actor.determineWordCount(this);
            }
        } catch (StopWordsReaderException | FieldOfWordCountNullException e) {
            printErrorMessageToConsole(e);
            System.exit(-1);
        }
    }

    private void printErrorMessageToConsole(RuntimeException e) {
        consolePrinter.print(e.getLocalizedMessage());
    }
}
