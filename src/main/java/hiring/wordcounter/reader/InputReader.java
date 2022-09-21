package hiring.wordcounter.reader;

import hiring.wordcounter.main.Reader;

import java.util.Scanner;

public class InputReader implements Reader {
    @Override
    public String read() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter text:");

            return scanner.nextLine();
        }
    }
}
