import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner1 = new Scanner(System.in);
        String word;
//        String playAgain;
        System.out.println("1 or 2 players?");
        String players = scanner1.nextLine();
        if (players.equals("1")) {
            //Added file scanner to generate words from the separate file
            Scanner scanner = new Scanner(new File("C:/Users/vic86/OneDrive/Documents/hangman-words.txt"));
//            String againPlay = scanner1.next();

            List<String> words = new ArrayList<>();

            //Loop create to run words in file added
            while (scanner.hasNext()) {
                words.add(scanner.nextLine());
            }
            //Added random function to get a word from the list
            Random rand = new Random();
            word = words.get(rand.nextInt(words.size()));
        }
        else {
            System.out.println("Player 1, Guess a letter: 1");
            word = scanner1.nextLine();
        }


        List<Character> guess = new ArrayList<>();

        int wrongAnswer = 0;
        while (true) {
            printWordProgress(word, guess);

            hangedMan(wrongAnswer);
            if (wrongAnswer >= 5) {
                System.out.println("You Lost!! The word is: " + word);
                System.out.println("Do you want to play again? (yes or no)");
//                playAgain = scanner1.next();
                break;
            }

            printWordProgress(word, guess);
            if(!getPlayerGuess(scanner1, word, guess)) {
               wrongAnswer++;
            }

            if(printWordProgress(word, guess)) {
                System.out.println("Yes! The secret word is " + word + " You win!!");
                System.out.println("Do you want to play again? (yes or no)");
//                playAgain = scanner1.next();
                break;
            }
        }
    }
    //Created method to keep track of wrong answer
    private static void hangedMan(int wrongAnswer) {
        System.out.println("+------+");
        try {
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
        } catch (Exception e) {
            System.out.println("Invalid Input: Please enter a letter");
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
