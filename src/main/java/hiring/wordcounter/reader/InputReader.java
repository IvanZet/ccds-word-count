package hiring.wordcounter.reader;

import java.util.Scanner;

public class InputReader {
    public String read() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter text:");

            return scanner.nextLine();
        }
    }
}
