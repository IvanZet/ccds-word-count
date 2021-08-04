import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FooTest {
    private Foo foo;

    @BeforeEach
    public void setUp() {
        foo = new Foo();
    }

    @Test
    @DisplayName("Simple word count test")
    void testWordCount() {
        assertEquals("Number of words: 4", foo.findWordCount("mytext.txt"),
                "Regular word count should work");
    }
}
