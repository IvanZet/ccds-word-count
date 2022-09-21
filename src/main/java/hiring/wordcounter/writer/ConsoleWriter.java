package hiring.wordcounter.writer;

import hiring.wordcounter.main.Writer;

public class ConsoleWriter implements Writer {
    @Override
    public void write(String text) {
        System.out.println(text);
    }
}
