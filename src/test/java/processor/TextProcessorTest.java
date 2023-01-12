package processor;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextProcessorTest {


    private TextProcessor textProcessor;

    @BeforeEach
    void setUp() {
        textProcessor = new TextProcessor();
    }

    @Test
    public void testCountWords_NonEmptyText_ReturnWordsCount() {
        assertEquals(5, textProcessor.countWords("Mary had a little lamb"));
    }

    @Test
    public void testCountWords_EmptyText_ReturnWordsCountAsZero() {
        assertEquals(0, textProcessor.countWords(" "));
    }

    @Test
    public void testCountWords_TextAsNull_ReturnWordsCountAsZero() {
        assertEquals(0, textProcessor.countWords(null));
    }

}
