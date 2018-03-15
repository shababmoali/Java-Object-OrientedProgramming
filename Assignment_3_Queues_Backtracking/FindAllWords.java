/*
* Name: <Shabab Ali>
* ID: <V00651717>
* Date: <Mar 04 2018>
* Filename: <FindAllWords.java>
* Details: <CSC115\Assn3\FindAllWords.java>: A Java program (verified compiler - JDK8u131) 
			that meets the criteria for developing an iterator that reads words from a custom .txt file
			and utilizes a recursive backtracking algorithm to determine whether they exist on the GameBoard object.
*/


/**
 * FindAllWords.java
 * @author Mike Zastre
 * 
 * For use with Assignment #3, UVic CSC 115 (Spring 2018)
 * University of Victoria.
 */ 

import java.util.*;
import java.io.*;

/**
 * When run as a program, FindAllWords creates a GameBoard
 * using the first parameter as a seed, and reads the
 * word file (whose named is provided as the second parameter)
 * line-by-line. For each word, this program determines if
 * the word can be found in the GameBoard instance created.
 */
public class FindAllWords {


    public static void main(String args[]) {

        if (args.length < 2) {
            System.err.println(
                "usage: java ValidateWord <seed> <filename>"
            );
            System.exit(1);
        }

        try {
            long seed = Long.parseLong(args[0]);
            String word = args[1].toUpperCase();

            GameBoard gb = new GameBoard(seed);
            System.out.println(gb.toString());

            /* Student code here for opening the file,
             * then reading it line by line, and for each
             * line (which is a single word) determining
             * whether or not the word appears on
             * the GameBoard instance.
             *
             * Note: The name of the file is in argv[1].
             */
			
			// Create File object and Scanner object to iterate through the file's Strings.
			// Determine if the Strings exist on the GameBoard object as part of the Scanner iteration,
			// by calling isWord() class method.
			File inF = new File(args[1]);
			Scanner inputF = new Scanner(inF);
			
			while (inputF.hasNext()) {
				String query = inputF.next();
				String result = gb.isWord(query);
				// Print succesful results to console
				if ( result != null ) {
					System.out.println(query + ": " + result);
				}
				
			} //end Scanner iteration
			 
        }
        catch (NumberFormatException nfe) {
            System.err.println(
                "'" + args[0] + "' " + 
                "given for <seed>; <seed> needs to be a valid integer"
            );
            System.exit(1);
        }
		catch (FileNotFoundException exception) {
			System.out.println("The file was not found.");
		}

    } //end void main(String args[])


} //end class FindAllWords
