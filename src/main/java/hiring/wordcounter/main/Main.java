package hiring.wordcounter.main;

import hiring.wordcounter.counter.WordCounter;
import hiring.wordcounter.consolereader.InputInputReaderImpl;
import hiring.wordcounter.filereader.StopWordsReader;
import hiring.wordcounter.writer.ConsoleWriter;

/**
 * The main class stat instantiates all dependencies and runs the app
 */
public class Main {

    private final Counter counter;
    private final InputReader inputReader;
    private final FileReader reader;
    private final Writer writer;

    /**
     * Constructor for this class
     *
     * @param counter       counter object which counts words in the input
     * @param inputReader   inputReader object that reads user's input from console
     * @param writer        writer object that writes the result back to the console
     * @param reader        rader object that reads stop words
     */
    public Main (Counter counter, InputReader inputReader, Writer writer, FileReader reader) {
        this.counter = counter;
        this.inputReader = inputReader;
        this.writer = writer;
        this.reader = reader;
    }

    /**
     * Starts this app
     */
    public void run() {
        writer.write(String.valueOf(counter.count(inputReader.read(), reader.read())));
    }

    public static void main(final String[] args) {
        Counter counter = new WordCounter();
        InputReader inputReader = new InputInputReaderImpl();
        Writer writer = new ConsoleWriter();
        FileReader reader = new StopWordsReader();

        new Main(counter, inputReader, writer, reader).run();
    }
}
