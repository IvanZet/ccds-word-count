package net.ivanzykov.wordcounter.userinputreader;

import net.ivanzykov.wordcounter.main.UserInputReader;

import java.util.Scanner;

public class UserInputReaderImpl implements UserInputReader {

    /**
     * Reads user's input from the console.
     *
     * @return  string with user's input
     */
    @Override
    public String read() {
        try (Scanner scanner = new Scanner(System.in)) {
            // FIXME: better move it to other class
            System.out.println("Enter text:");

            return scanner.nextLine();
        }
    }
}
