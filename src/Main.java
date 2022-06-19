import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("C:/Users/vic86/OneDrive/Documents/hangman-words.txt"));

        List<String> words = new ArrayList<>();
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
    }
}
