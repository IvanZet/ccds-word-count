package net.ivanzykov.wordcounter.wordscounter;

import net.ivanzykov.wordcounter.WordCounterApp;
import net.ivanzykov.wordcounter.stopwordsreader.StopWordsReaderImpl;
import net.ivanzykov.wordcounter.userinputreader.UserInputReaderImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WordsCounterImplTest {

    @ParameterizedTest
    @MethodSource("provideCount")
    void count_differentInput_correctCount(String text, int count) {
        // Simulate user's input
        InputStream standardIn = System.in;
        System.setIn(new ByteArrayInputStream(text.getBytes()));

        // Instantiate SUT
        WordsCounterImpl wordCounter = new WordsCounterImpl(
                new UserInputReaderImpl(), WordCounterApp.STOP_WORDS_FILENAME, new StopWordsReaderImpl());

        assertEquals(count, wordCounter.count());

        // Restore standard in
        System.setIn(standardIn);
    }

    private static Stream<Arguments> provideCount() {
        return Stream.of(
                Arguments.of("hello", 1),
                Arguments.of("hello world", 2),
                Arguments.of("hello w1rld", 1),
                Arguments.of("hello 3", 1),
                Arguments.of("hello #", 1),
                Arguments.of("hello a the on off", 1)
        );
    }
}
