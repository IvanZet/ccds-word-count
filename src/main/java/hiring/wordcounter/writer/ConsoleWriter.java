package hiring.wordcounter.writer;

import hiring.wordcounter.main.Writer;

public class ConsoleWriter implements Writer {

    /**
     * Displays result of the app in the console.
     *
     * @param text  string which is displayed in the console
     */
    @Override
    public void write(String text) {
        System.out.println(text);
    }
}
