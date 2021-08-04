import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Foo {

    String convertTextToList(String text) {
        List<String> wordArrayList = new ArrayList<>();
        for (String word : text.split(" ")) {
            wordArrayList.add(word);
        }
        wordArrayList.removeAll(Arrays.asList("", null));
        return "Number of words: " + wordArrayList.size();
    }
}
