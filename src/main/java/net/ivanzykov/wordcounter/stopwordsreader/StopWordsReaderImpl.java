package net.ivanzykov.wordcounter.stopwordsreader;

import net.ivanzykov.wordcounter.wordscounter.StopWordsReader;
import net.ivanzykov.wordcounter.runner.StopWordsReaderException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StopWordsReaderImpl implements StopWordsReader {

    private final String fileName;

    /**
     * Constructor for this class.
     *
     * @param fileName  string with the name of the file with stop words
     */
    public StopWordsReaderImpl(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Reads stop words from the file in the source
     *
     * @return  list with strings of all the stop words
     */
    @Override
    public List<String> read() {
        List<String> words;
        try {
            Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                    .getResource(fileName)).toURI());
            try (Stream<String> lines = Files.lines(path)) {
                words = lines.collect(Collectors.toList());
            }
        } catch (NullPointerException e) {
            throw new StopWordsReaderException("File with stop words not found.");
        } catch (URISyntaxException | IOException e) {
            throw new StopWordsReaderException("Failed to read the file with stop words." + System.lineSeparator() +
                    e.getMessage());
        }
        return words;
    }
}
