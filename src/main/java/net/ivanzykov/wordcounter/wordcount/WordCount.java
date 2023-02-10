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
    private Integer countOfAllWords;
    private final List<Actor> actors;

    /**
     * Constructor of this class.
     *
     * @param stopWordsFileName string with the name of the file with stop words
     * @param actors            list of actor objects that do their part of the job to determine the count of words
     */
    public WordCount(String stopWordsFileName, List<Actor> actors) {
        this.stopWordsFileName = stopWordsFileName;
        this.actors = actors;
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

    public Integer getCountOfAllWords() {
        return countOfAllWords;
    }

    public void setCountOfAllWords(Integer countOfAllWords) {
        this.countOfAllWords = countOfAllWords;
    }

    /**
     * Calls components of this app to determine the count of words in user's input and handles exceptions.
     */
    public void count() {
        try {
            for (Actor actor : actors) {
                actor.determineWordCount(this);
            }
        } catch (FileReaderException | FieldOfWordCountNullException e) {
            throw new CriticalAppException(e.getLocalizedMessage());
        }
    }
}
