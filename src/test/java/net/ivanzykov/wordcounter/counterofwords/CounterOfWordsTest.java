package net.ivanzykov.wordcounter.counterofwords;

import net.ivanzykov.wordcounter.WordCounterApp;
import net.ivanzykov.wordcounter.runner.WordCount;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CounterOfWordsTest {

    @Test
    void determineWordCount() {
        // Prepare args
        WordCount wordCount = new WordCount(WordCounterApp.STOP_WORDS_FILENAME);
        wordCount.setStopWords(Arrays.asList("the", "a", "on", "off"));
        wordCount.setUsersInput("hello w1rld 3 # the a on off");

        // Check blanc state before this test
        assertNull(wordCount.getCountOfWords());

        // Run this test
        new CounterOfWords().determineWordCount(wordCount);

        assertEquals(1, wordCount.getCountOfWords());
    }
}
