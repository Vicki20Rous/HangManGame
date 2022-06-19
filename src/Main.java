import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        //Added file scanner to generate words
        Scanner scanner = new Scanner(new File("C:/Users/vic86/OneDrive/Documents/hangman-words.txt"));

        List<String> words = new ArrayList<>();

        //Loop create to run words in file added
        while (scanner.hasNext()) {
            words.add(scanner.nextLine());
        }
        //Added random function to get a word from the list
        Random rand = new Random();
        String word = words.get(rand.nextInt(words.size()));
        System.out.print(word);
    }
}
