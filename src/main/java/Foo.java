import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Foo {

    String findWordCount(String fileName) {
        List<String> words = new ArrayList<>();
        textFileReader(words, fileName);
        return "Number of words: " + words.size();
    }

    void textFileReader(List<String> words, String fileName) {
        BufferedReader br;
        String line = "";
        List<String> stopWords = readStopWordsFromFile();
        try {
            br = new BufferedReader(new FileReader(fileName));
            try {
                while ((line = br.readLine()) != null) {
                    for (String word : line.split(" ")) {
                        if (!stopWords.contains(word)) {
                            words.add(word);
                        }
                    }
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    List<String> readStopWordsFromFile() {
        String stopWordFileName = "stopwords.txt";
        List<String> stopWordArrayList = new ArrayList<>();
        stopFileReader(stopWordArrayList, stopWordFileName);
        return stopWordArrayList;
    }

    void stopFileReader(List<String> words, String fileName) {
        BufferedReader br;
        String line = "";
        try {
            br = new BufferedReader(new FileReader(fileName));
            try {
                while ((line = br.readLine()) != null) {
                    words.add(line);
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
