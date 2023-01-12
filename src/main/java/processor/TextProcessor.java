package processor;


public class TextProcessor {

    public int countWords(String text) {
        if (text == null) {
            return 0;
        }
        if (text != null && text.equalsIgnoreCase("")) {
            return 0;
        }
        String[] words = text.split(" ");
        return words.length;
    }
}
