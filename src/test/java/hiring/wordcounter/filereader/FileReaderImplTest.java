package hiring.wordcounter.filereader;

import hiring.wordcounter.main.FileReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderImplTest {

    @Test
    void read_fileWithwords_checkContent() {
        FileReader fileReader = new FileReaderImpl();

        String expected = "the" + System.lineSeparator() +
                "a" + System.lineSeparator() +
                "on" + System.lineSeparator() +
                "off";
        assertEquals(expected, fileReader.read());
    }
}
