package net.ivanzykov.wordcounter.stopwordsreader;

import net.ivanzykov.wordcounter.FileReader;
import net.ivanzykov.wordcounter.wordcount.Actor;
import net.ivanzykov.wordcounter.wordcount.FileReaderException;
import net.ivanzykov.wordcounter.wordcount.WordCount;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StopWordsReader implements Actor, FileReader {

    /**
     * Reads stop words from a file in the source
     *
     * @param wordCount wordCount object holding name of the file with stop words and for storing the result of this
     *                  method
     */
    @Override
    public void determineWordCount(WordCount wordCount) {
        List<String> stopWords;
        try {
            Path path = getPathOfTheFile(wordCount.getStopWordsFileName());
            try (Stream<String> lines = Files.lines(path)) {
                stopWords = lines.collect(Collectors.toList());
            }
        } catch (NullPointerException e) {
            throw new FileReaderException("File with stop words not found.");
        } catch (URISyntaxException | IOException e) {
            throw new FileReaderException("Failed to read the file with stop words." + System.lineSeparator() +
                    e.getMessage());
        }
        wordCount.setStopWords(stopWords);
    }
}
