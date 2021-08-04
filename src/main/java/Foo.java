import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Foo {

    String convertTextToList(String text) {
        List<String> wordArrayList = new ArrayList<>();
        for (String word : text.split(" ")) {
            wordArrayList.add(word);
        }
        removeStopWordsFromList(wordArrayList);
        return "Number of words: " + wordArrayList.size();
    }

    void removeStopWordsFromList(List<String> list) {
        String fileName = "stopwords.txt";
        BufferedReader br;
        String line = "";

        try {
            br = new BufferedReader(new FileReader(fileName));
            try {
                while((line = br.readLine()) != null) {
                    if (list.contains(line)) {
                        list.remove(line);
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
}
