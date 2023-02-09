package net.ivanzykov.wordcounter.userinputreader;

import net.ivanzykov.wordcounter.wordcount.Actor;
import net.ivanzykov.wordcounter.wordcount.ConsolePrinter;

public class UserInputFactory {

    private UserInputFactory() {
    }

    public static Actor createUserInputReader(String filename, ConsolePrinter consolePrinter) {
        if (filename == null) {
            return new UserInputConsoleReader(consolePrinter);
        }
        return new UserInputFileReader(filename);
    }
}
