package net.ivanzykov.wordcounter.userinputreader;

import net.ivanzykov.wordcounter.wordcount.Actor;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserInputFactoryTest {

    private static Stream<Arguments> provide_createUserInputReader_createsCorrectUserInputReader() {
        return Stream.of(
                Arguments.of("test.txt", UserInputFileReader.class),
                Arguments.of(null, UserInputConsoleReader.class)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "provide_createUserInputReader_createsCorrectUserInputReader")
    void createUserInputReader_createsCorrectUserInputReader(String filename, Class<Actor> expected) {
        Actor userInputReader = UserInputFactory.createUserInputReader(filename, null);
        assertEquals(expected, userInputReader.getClass());
    }
}
