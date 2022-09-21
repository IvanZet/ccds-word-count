package hiring.wordcounter.counter;

public class WordCounter {
    public int count(String text) {
        String[] splitText = text.split("");

        return splitText.length;
    }
}
