package net.ivanzykov.wordcounter.stopwordsreader;

import net.ivanzykov.wordcounter.wordscounter.StopWordsReader;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StopWordsReaderImplTest {

    @Test
    void read_fileWithWords_checkContent() {
        StopWordsReader stopWordsReader = new StopWordsReaderImpl();
        List<String> expected = Arrays.asList("the", "a", "on", "off");
        assertEquals(expected, stopWordsReader.read("stopwords.txt"));
    }
}
