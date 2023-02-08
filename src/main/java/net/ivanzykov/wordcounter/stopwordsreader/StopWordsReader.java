package net.ivanzykov.wordcounter.stopwordsreader;

import net.ivanzykov.wordcounter.wordcount.Actor;
import net.ivanzykov.wordcounter.wordcount.StopWordsReaderException;
import net.ivanzykov.wordcounter.wordcount.WordCount;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StopWordsReader implements Actor {

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
            Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                    .getResource(wordCount.getStopWordsFileName())).toURI());
            try (Stream<String> lines = Files.lines(path)) {
                stopWords = lines.collect(Collectors.toList());
            }
        } catch (NullPointerException e) {
            throw new StopWordsReaderException("File with stop words not found.");
        } catch (URISyntaxException | IOException e) {
            throw new StopWordsReaderException("Failed to read the file with stop words." + System.lineSeparator() +
                    e.getMessage());
        }
        wordCount.setStopWords(stopWords);
    }
}
