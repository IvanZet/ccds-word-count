package net.ivanzykov.wordcounter;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * For classes reading files.
 */
public interface FileReader {
    default Path getPathOfTheFile(String filename) throws URISyntaxException {
        return Paths.get(Objects.requireNonNull(getClass().getClassLoader()
                .getResource(filename)).toURI());
    }
}
