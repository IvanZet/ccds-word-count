package net.ivanzykov.wordcounter.counterofwords;

import net.ivanzykov.wordcounter.App;
import net.ivanzykov.wordcounter.wordcount.WordCount;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CounterOfUniqueWordsTest {

    @Test
    void determineWordCount() {
        WordCount wordCount = new WordCount(App.STOP_WORDS_FILENAME, null);
        wordCount.setUsersInput("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.");
        wordCount.setStopWords(Arrays.asList("the", "a", "on", "off"));

        assertNull(wordCount.getCountOfUniqueWords());

        new CounterOfUniqueWords().determineWordCount(wordCount);

        assertEquals(7, wordCount.getCountOfUniqueWords());
    }
}
