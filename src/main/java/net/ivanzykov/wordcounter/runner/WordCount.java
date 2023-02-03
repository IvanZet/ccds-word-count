package net.ivanzykov.wordcounter.runner;

import java.util.List;

public class WordCount {

    private List<String> stopWords;
    private final String stopWordsFileName;

    public WordCount(String stopWordsFileName) {
        this.stopWordsFileName = stopWordsFileName;
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
}
