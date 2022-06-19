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

        int wrongAnswer = 0;
        while (true) {
            printWordProgress(word, guess);

            System.out.println("+------+");

            if (wrongAnswer >= 1) {
                System.out.println("O ");
            }

            if (wrongAnswer >= 2) {
                System.out.println("|");
            }
            if (wrongAnswer >= 3) {
                    System.out.println("|");
            }

            if (wrongAnswer >= 4) {
                System.out.println("|");
            }

            if (wrongAnswer >= 5) {
                System.out.println("===");
            }
            System.out.println("");
            System.out.println("");

            printWordProgress(word, guess);
            if(!getPlayerGuess(scanner1, word, guess)) {
               wrongAnswer++;
            }

            if(printWordProgress(word, guess)) {
                System.out.println("You win!!");
                break;
            }
        }

    }
    //Created method to keep track of the input from the player
    private static boolean getPlayerGuess(Scanner scanner1, String word, List<Character> guess) {
        System.out.println("Guess a Letter: ");
        String letterGuess = scanner1.nextLine();
        guess.add(letterGuess.charAt(0));
        return word.contains(letterGuess);

    }
    //Created a method to keep track of the player guesses
    private static boolean printWordProgress(String word, List<Character> guess) {
        int correctAnswer = 0;
        for (int i = 0; i < word.length(); i++) {
            if (guess.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
                correctAnswer++;
            } else {
                System.out.print("-");
            }
        }
        System.out.println();
        return (word.length() == correctAnswer);
    }
}
