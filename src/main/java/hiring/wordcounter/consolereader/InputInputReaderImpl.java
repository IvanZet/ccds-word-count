package hiring.wordcounter.consolereader;

import hiring.wordcounter.main.InputReader;

import java.util.Scanner;

public class InputInputReaderImpl implements InputReader {
    @Override
    public String read() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter text:");

            return scanner.nextLine();
        }
    }
}
