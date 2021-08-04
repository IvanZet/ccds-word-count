import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("wordcount ");
        String fileName = scan.nextLine();
        Foo foo = new Foo();
        System.out.println(foo.findWordCount(fileName));
    }
}
