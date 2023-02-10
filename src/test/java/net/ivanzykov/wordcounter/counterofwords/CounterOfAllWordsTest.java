package net.ivanzykov.wordcounter.counterofwords;

import net.ivanzykov.wordcounter.App;
import net.ivanzykov.wordcounter.wordcount.Actor;
import net.ivanzykov.wordcounter.wordcount.FieldOfWordCountNullException;
import net.ivanzykov.wordcounter.wordcount.WordCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CounterOfAllWordsTest {

    private WordCount wordCount;
    private Actor counterOfWords;

    @BeforeEach
    void setUp() {
        wordCount = new WordCount(App.STOP_WORDS_FILENAME, null);
        counterOfWords = new CounterOfAllWords();
    }

    private static Stream<Arguments> provide_determineWordCount_setsWordCountInWordCount() {
        return Stream.of(
                Arguments.of("hello w1rld 3 # the a on off", 3),
                Arguments.of("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.", 9)
        );
    }

    @ParameterizedTest
    @MethodSource("provide_determineWordCount_setsWordCountInWordCount")
    void determineWordCount_setsWordCountInWordCount(String usersInput, Integer expected) {
        // Prepare args
        wordCount.setStopWords(Arrays.asList("the", "a", "on", "off"));
        wordCount.setUsersInput(usersInput);

        // Check blanc state before this test
        assertNull(wordCount.getCountOfWords());

        // Run this test
        counterOfWords.determineWordCount(wordCount);

        assertEquals(expected, wordCount.getCountOfWords());
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
