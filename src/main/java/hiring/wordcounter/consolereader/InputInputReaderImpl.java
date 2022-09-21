package hiring.wordcounter.consolereader;

import hiring.wordcounter.main.InputReader;

import java.util.Scanner;

public class InputInputReaderImpl implements InputReader {

    /**
     * Reads users input from the console
     *
     * @return  string with user's input
     */
    @Override
    public String read() {
        try (Scanner scanner = new Scanner(System.in)) {
            // FIXME: instead, use the Writer interface to print this to the console
            System.out.println("Enter text:");

            return scanner.nextLine();
        }
    }
}
