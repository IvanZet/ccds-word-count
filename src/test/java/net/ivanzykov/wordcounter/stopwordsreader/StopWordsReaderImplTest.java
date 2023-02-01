package net.ivanzykov.wordcounter.stopwordsreader;

import net.ivanzykov.wordcounter.WordCounterApp;
import net.ivanzykov.wordcounter.wordscounter.StopWordsReader;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StopWordsReaderImplTest {

    @Test
    void read_fileWithWords_checkContent() {
        StopWordsReader stopWordsReader = new StopWordsReaderImpl(WordCounterApp.STOP_WORDS_FILENAME);
        assertEquals(Arrays.asList("the", "a", "on", "off"), stopWordsReader.read());
    }
}
