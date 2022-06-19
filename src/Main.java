import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        //Added file scanner to generate words from the separate file
        Scanner scanner = new Scanner(new File("C:/Users/vic86/OneDrive/Documents/hangman-words.txt"));
        //Added input scanner for players input
        Scanner scanner1 = new Scanner(System.in);

        List<String> words = new ArrayList<>();

        //Loop create to run words in file added
        while (scanner.hasNext()) {
            words.add(scanner.nextLine());
        }
        //Added random function to get a word from the list
        Random rand = new Random();
        String word = words.get(rand.nextInt(words.size()));
        System.out.println(word);

        List<Character> guess = new ArrayList<>();

        //Created a method to keep track of the player guesses
        printWordProgress(word, guess);

        //Creating Loop to get the input from the player
    }

    private static void printWordProgress(String word, List<Character> guess) {
        for (int i = 0; i < word.length(); i++) {
            if (guess.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
            } else {
                System.out.print("-");
            }
        }
        System.out.println();
    }
}
