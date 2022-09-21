package hiring.wordcounter.main;

import hiring.wordcounter.counter.WordCounter;
import hiring.wordcounter.consolereader.InputInputReaderImpl;
import hiring.wordcounter.filereader.FileReaderImpl;
import hiring.wordcounter.writer.ConsoleWriter;

public class Main {

    private final Counter counter;
    private final InputReader inputReader;
    private final FileReader reader;
    private final Writer writer;

    public Main (Counter counter, InputReader inputReader, Writer writer, FileReader reader) {
        this.counter = counter;
        this.inputReader = inputReader;
        this.writer = writer;
        this.reader = reader;
    }

    public void run() {
        writer.write(String.valueOf(counter.count(inputReader.read(), reader.read())));
    }

    public static void main(final String[] args) {
        Counter counter = new WordCounter();
        InputReader inputReader = new InputInputReaderImpl();
        Writer writer = new ConsoleWriter();
        FileReader reader = new FileReaderImpl();

        new Main(counter, inputReader, writer, reader).run();
    }
}
