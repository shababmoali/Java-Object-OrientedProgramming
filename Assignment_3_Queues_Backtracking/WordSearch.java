/**
 * WordSearch.java
 * @author Mike Zastre
 * 
 * For use with Assignment #3, UVic CSC 115 (Spring 2018)
 * University of Victoria.
 */ 

import java.util.*;

/**
 * This program prompts the user for a random seed (used to
 * initialize a GameBoard instance). It then loops through
 * prompts for a word, which is the used as an argument
 * to isWord() of the GameBoard instance, and reports the
 * result. (The loop terminates if the exclamation point --
 * the ! character -- is given as the word.)
 *
 * Note that the word obtain from the user is first
 * converted into a canonical form (i.e., all upper-case
 * case characters) before the call to isWord().
 */
public class WordSearch {
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        long seed;

        while(true) {
            try {
                System.out.print("Random seed? ");
                seed = keyboard.nextInt(); 
                break;
            }
            catch (InputMismatchException ime) {
                System.out.println("Please enter a valid integer."); 
            }
        }

        GameBoard gb = new GameBoard(seed);
        System.out.println(gb);

        while (true) {
            System.out.print("Word to search (enter ! to exit)? ");
            String word = keyboard.next();

            if (word.equals("!")) {
                break;
            }

            word = word.toUpperCase();

            String path = gb.isWord(word);
            if (path == null) {
                System.out.println("no path");
            } else {
                System.out.println(gb.isWord(word));
            }
        }
    }
}
