import java.io.*;
import java.util.*;

public class HangmanGame {
    public static void main(String[] args) {
        ArrayList<String> Words = new ArrayList<>();

        // Reading words from file
        try (BufferedReader reader = new BufferedReader(new FileReader("temp.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Words.add(line.trim());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!");
            return;
        } catch (IOException e) {
            System.out.println("Something went wrong!!");
            return;
        }

        if (Words.isEmpty()) {
            System.out.println("No words loaded from the file.");
            return;
        }

        // Select random word
        Random random = new Random();
        String finalWord = Words.get(random.nextInt(Words.size()));
        ArrayList<Character> Word = new ArrayList<>();

        for (int i = 0; i < finalWord.length(); i++) {
            Word.add('_');
        }

        int wrongGuesses = 0;

        System.out.println("#################################################");
        System.out.println("WELCOME TO HANGMAN WORD GUESSING GAME BY RAVI....");
        System.out.println("#################################################\n");
         System.out.print("Guess this word by the outline to win the game and save the man : ");
            for (char w : Word) {
                System.out.print(w + " ");
            }
            System.out.println("\n");

        Scanner scanner = new Scanner(System.in);

        while (wrongGuesses < 6) {
            System.out.print("CURRENT STATE:");
        
            for (char w : Word) {
                System.out.print(w + " ");
            }
  System.out.println("\n");
             System.out.println(getHangman( wrongGuesses)); 

            System.out.print("\nGuess a character: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            if (finalWord.indexOf(guess) >= 0) {
                System.out.println("CORRECT GUESS!");

                for (int i = 0; i < finalWord.length(); i++) {
                    if (guess == finalWord.charAt(i)) {
                        Word.set(i, guess);
                    }
                }

                if (!Word.contains('_')) {
                    System.out.println("GAME OVER...\n**********\nYOU WON!\n**********\nTHE WORD WAS: " + finalWord);
                      System.out.println(getHangman( wrongGuesses)); 
                    break;
                }

            } else {
                wrongGuesses++;
                System.out.println("WRONG GUESS!");
            

       
        }
    }
         if (wrongGuesses >= 6) {
                System.out.println("\nGAME OVER...\n**********\nYOU LOST!\n**********\nTHE WORD WAS: " + finalWord);
                System.out.println(getHangman( wrongGuesses)); 

        scanner.close();
         }
    }
    static String getHangman(int wrongGuesses){
    return switch(wrongGuesses){
        case 0 -> """
         _______
        |/      
        |      
        |      
        |       
        |      
       _|_
        """;
        case 1 -> """
         _______
        |/      |
        |      ( )
        |      
        |       
        |      
       _|_
        """;
        case 2 -> """
         _______
        |/      |
        |      ( )
        |       |
        |       
        |      
       _|_
        """;
        case 3 -> """
         _______
        |/      |
        |      ( )
        |      /|
        |       
        |      
       _|_
        """;
        case 4 -> """
         _______
        |/      |
        |      ( )
        |      /|\\
        |       
        |      
       _|_
        """;
        case 5 -> """
         _______
        |/      |
        |      ( )
        |      /|\\
        |      / 
        |      
       _|_
        """;
        case 6 -> """
         _______
        |/      |
        |      ( )
        |      /|\\
        |      / \\
        |      
       _|_
        """;
        default -> "";
    };
}

}


