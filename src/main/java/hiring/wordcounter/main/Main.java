package hiring.wordcounter.main;

import hiring.wordcounter.counter.WordCounter;
import hiring.wordcounter.consolereader.InputReader;
import hiring.wordcounter.writer.ConsoleWriter;

public class Main {

    private Counter counter;
    private Reader reader;
    private Writer writer;

    public Main (Counter counter, Reader reader, Writer writer) {
        this.counter = counter;
        this.reader = reader;
        this.writer = writer;
    }

    public void run() {
        writer.write(String.valueOf(counter.count(reader.read())));
    }

    public static void main(final String[] args) {
        Counter counter = new WordCounter();
        Reader reader = new InputReader();
        Writer writer = new ConsoleWriter();

        new Main(counter, reader, writer).run();
    }
}
