import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scan.nextLine();
        Foo foo = new Foo();
        System.out.println(foo.convertTextToList(text));
    }
}
