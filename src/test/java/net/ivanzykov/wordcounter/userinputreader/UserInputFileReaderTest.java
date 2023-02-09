package net.ivanzykov.wordcounter.userinputreader;

import net.ivanzykov.wordcounter.App;
import net.ivanzykov.wordcounter.wordcount.FileReaderException;
import net.ivanzykov.wordcounter.wordcount.WordCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInputFileReaderTest {

    private WordCount wordCount;
    private UserInputFileReader userInputFileReader;

    @BeforeEach
    void setUp() {
        wordCount = new WordCount(App.STOP_WORDS_FILENAME, null, null);
        userInputFileReader = new UserInputFileReader(null);
    }

    @Test
    void determineWordCount_readsUsersInputCorrectly() {
        userInputFileReader.setUsersInputFilename("mytext.txt");
        assertNull(wordCount.getUsersInput());
        userInputFileReader.determineWordCount(wordCount);
        assertEquals("Mary had a little lamb", wordCount.getUsersInput());
    }

    @Test
    void determineWordCount_handlesFileReaderException() {
        Exception exception = assertThrows(FileReaderException.class, () ->
                userInputFileReader.determineWordCount(wordCount));
        assertEquals("File with user's input not found.", exception.getMessage());
    }
}
