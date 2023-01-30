package net.ivanzykov.wordcounter.stopwordsreader;

import net.ivanzykov.wordcounter.runner.StopWordsReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StopWordsReaderImplTest {

    @Test
    void read_fileWithwords_checkContent() {
        StopWordsReader stopWordsReader = new StopWordsReaderImpl();

        String expected = "the" + System.lineSeparator() +
                "a" + System.lineSeparator() +
                "on" + System.lineSeparator() +
                "off";
        assertEquals(expected, stopWordsReader.read());
    }
}
