package net.ivanzykov.wordcounter.userinputreader;

import net.ivanzykov.wordcounter.wordcount.Actor;
import net.ivanzykov.wordcounter.wordcount.FileReader;
import net.ivanzykov.wordcounter.wordcount.FileReaderException;
import net.ivanzykov.wordcounter.wordcount.WordCount;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserInputFileReader implements Actor, FileReader {

    private String usersInputFilename;

    /**
     * Constructor of this class
     *
     * @param usersInputFilename string object with name of the file with user's input
     */
    public UserInputFileReader(String usersInputFilename) {
        this.usersInputFilename = usersInputFilename;
    }

    /**
     * Reads user's input from a file.
     *
     * @param wordCount wordCount object holding name of the file with stop words and for storing the result of this
     *                  method
     */
    @Override
    public void determineWordCount(WordCount wordCount) {
        String usersInput;
        try {
            Path path = getPathOfTheFile(usersInputFilename);
            try (Stream<String> lines = Files.lines(path)) {
                usersInput = lines.collect(Collectors.joining(" "));
            }
        } catch (NullPointerException e) {
            throw new FileReaderException("File with user's input not found.");
        } catch (URISyntaxException | IOException e) {
            throw new FileReaderException("Failed to read the file with user's input." + System.lineSeparator() +
                    e.getMessage());
        }
        wordCount.setUsersInput(usersInput);
    }

    public void setUsersInputFilename(String usersInputFilename) {
        this.usersInputFilename = usersInputFilename;
    }
}
