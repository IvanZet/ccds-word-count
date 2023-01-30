package net.ivanzykov.wordcounter.stopwordsreader;

import net.ivanzykov.wordcounter.runner.StopWordsReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StopWordsReaderImpl implements StopWordsReader {

    /**
     * Reads stop words from a file in the source
     *
     * @return  string with all the stop words
     */
    @Override
    public String read() {
        String words = "";
        try {
            URL url = getClass().getClassLoader()
                    .getResource("stopwords.txt");
            Path path = null;
            if (url != null) {
                path = Paths.get(url.toURI());
            } else {
                // TODO: use ConsoleWriter
                System.out.println("Error reading the word file");
                System.exit(-1);
            }
            try (Stream<String> lines = Files.lines(path);) {
                words = lines.collect(Collectors.joining(System.lineSeparator()));
            }
        } catch (URISyntaxException e) {
            System.out.println(e.getLocalizedMessage());
            System.exit(-1);
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
            System.exit(-1);
        }
        return words;
    }
}
