package hiring.wordcounter.reader;

import java.util.Scanner;

public class InputReader {
    private final Counter counter;

    public InputReader(Counter counter) {
        this.counter = counter;
    }

    public String read() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter text:");

            return scanner.nextLine();
        }
    }
}
