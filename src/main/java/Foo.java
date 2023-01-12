import processor.TextProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Foo {
    public static void main(String[] args) {
        System.out.println("Please input words/lines: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputText;
        try {
            inputText = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        TextProcessor textProcessor = new TextProcessor();
        System.out.println("Number of words your input contains: " + textProcessor.countWords(inputText));
    }
}
