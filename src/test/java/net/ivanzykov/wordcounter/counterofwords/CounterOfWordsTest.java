package net.ivanzykov.wordcounter.counterofwords;

import net.ivanzykov.wordcounter.App;
import net.ivanzykov.wordcounter.wordcount.Actor;
import net.ivanzykov.wordcounter.wordcount.FieldOfWordCountNullException;
import net.ivanzykov.wordcounter.wordcount.WordCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CounterOfWordsTest {

    private WordCount wordCount;
    private Actor counterOfWords;

    @BeforeEach
    void setUp() {
        wordCount = new WordCount(App.STOP_WORDS_FILENAME, null);
        counterOfWords = new CounterOfWords();
    }

    @Test
    void determineWordCount_setsWordCountInWordCount() {
        // Prepare args
        wordCount.setStopWords(Arrays.asList("the", "a", "on", "off"));
        wordCount.setUsersInput("hello w1rld 3 # the a on off");

        // Check blanc state before this test
        assertNull(wordCount.getCountOfWords());

        // Run this test
        counterOfWords.determineWordCount(wordCount);

        assertEquals(1, wordCount.getCountOfWords());
    }

    @Test
    void determineWordCount_nullUsersInput_throwsException() {
        Exception exception = assertThrows(FieldOfWordCountNullException.class, () ->
                counterOfWords.determineWordCount(wordCount));

        assertEquals("Failed to count words. User's input is null in WordCount object", exception.getMessage());
    }

    @Test
    void determineWordCount_nullStopWords_throwsException() {
        wordCount.setUsersInput("abc");

        Exception exception = assertThrows(FieldOfWordCountNullException.class, () ->
                counterOfWords.determineWordCount(wordCount));

        assertEquals("Failed to count words. Stop words is null in WordCount object", exception.getMessage());
    }
}
