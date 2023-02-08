package net.ivanzykov.wordcounter.stopwordsreader;

import net.ivanzykov.wordcounter.App;
import net.ivanzykov.wordcounter.wordcount.WordCount;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StopWordsReaderTest {

    @Test
    void determineWordCount() {
        // Prepare args
        WordCount wordCount = new WordCount(App.STOP_WORDS_FILENAME, null, null);

        // Check blanc state before this test
        assertNull(wordCount.getStopWords());

        // Run this test
        new StopWordsReader().determineWordCount(wordCount);

        assertEquals(Arrays.asList("the", "a", "on", "off"), wordCount.getStopWords());
    }
}
