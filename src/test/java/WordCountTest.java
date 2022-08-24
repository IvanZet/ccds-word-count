import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WordCountTest {

    private WordCount tested;


    @BeforeEach
    void setUp() {
        tested = new WordCount();
    }

    @Test
    void countWordsNull() {
        assertThrows(IllegalArgumentException.class, () -> tested.countWords(null));
    }

    @Test
    void countWordsEmpty() {
        assertEquals(0, tested.countWords(""));
    }

    @Test
    void countWordsBlank() {
        assertEquals(0, tested.countWords("   "));
    }


    @Test
    void countWordsSingleWord1() {
        assertEquals(1, tested.countWords(" a  "));
    }


    @Test
    void countWordsSingleWord2() {
        assertEquals(1, tested.countWords("adsaf"));
    }

    @Test
    void countWordsSingleWord3() {
        assertEquals(1, tested.countWords("adsaf"));
    }

    @Test
    void countWordsMultipleWords1() {
        assertEquals(2, tested.countWords("adsaf dsafsdf"));
    }

    @Test
    void countWordsMultipleWords2() {
        assertEquals(3, tested.countWords("adsaf dsafsdf a"));
    }


    @Test
    void countWordsIncorrectChars1() {
        assertEquals(1, tested.countWords("ad21saf,dsafsdf a"));
    }

    @Test
    void countWordsIncorrectChars2() {
        assertEquals(0, tested.countWords("ad21saf,-#$%dsafsdf"));
    }

}