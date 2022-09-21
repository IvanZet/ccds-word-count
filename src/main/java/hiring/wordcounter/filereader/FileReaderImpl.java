package hiring.wordcounter.filereader;

import hiring.wordcounter.main.FileReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReaderImpl implements FileReader {

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
