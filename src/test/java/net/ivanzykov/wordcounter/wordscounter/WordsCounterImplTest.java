package net.ivanzykov.wordcounter.wordscounter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class WordsCounterImplTest {
    @ParameterizedTest
    @MethodSource("provideCount")
    void count(String text, int count) {
        WordsCounterImpl wordCounter = new WordsCounterImpl();
        String stopwords = "the" + System.lineSeparator() +
                "a" + System.lineSeparator() +
                "on" + System.lineSeparator() +
                "off";
        assertEquals(count, wordCounter.count(text, stopwords));
    }

    private static Stream<Arguments> provideCount() {
        return Stream.of(
                Arguments.of("hello", 1),
                Arguments.of("hello world", 2),
                Arguments.of("hello w1rld", 1),
                Arguments.of("hello w1rld 3", 1),
                Arguments.of("hello w1rld #", 1),
                Arguments.of("hello a the on off", 1)
        );
    }
}
