import java.util.*;
import java.io.*;

/**
 * Provided for CSC 115, Assignment one (2018 Spring)
 *
 * @author Mike Zastre (UVic Department of Computer Science)
 * @version 1
 */
public class EncryptDecryptText {
    public static void main(String args[]) {
        String result = null;
        String infileName = null;
        String outfileName = null;
        boolean doEncryption = false;
        String key = null;

        // Process the command-line options and arguments.

        try {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-k")) {
                    key = args[i+1];
                } else if (args[i].equals("-e")) {
                    infileName = args[i+1];
                    doEncryption = true;
                } else if (args[i].equals("-d")) {
                    infileName = args[i+1];
                    doEncryption = false;
                } else if (args[i].equals("-o")) {
                    outfileName = args[i+1];
                }
            }

            if (infileName == null) {
                System.out.println("Usage: please provide an input filename");
            }

            if (outfileName == null) {
                System.out.println("Usage: please provide an output filename");
            }

            if (infileName == null || outfileName == null) {
                System.exit(1);
            }

            // If we reach this point in the code, we have all the information
            // needed to proceed with processing.

            Scanner infileScanner;
            PrintStream outfileStream;

            // **************************************************
            // THE NEXT STATMENT IS THE ONLY LINE TO BE MODIFIED
            // AND ONLY THE RIGHT-HAND SIDE AT THAT (TO THE RIGHT
            // OF THE = SIGN). SORRY FOR SHOUTING.
            //
            Cipher c = new NullCipher(key);

            infileScanner = new Scanner(new File(infileName));
            outfileStream = new PrintStream(new File(outfileName));
            if (doEncryption) {
                encryptStream(infileScanner, outfileStream, c);
                outfileStream.close();
            } else {
                decryptStream(infileScanner, outfileStream, c);
                outfileStream.close();
            }
        } 
        catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Probably not enough arguments provided.\n");
            System.exit(1);
        }

    }

    /**
     * Reads in one line of input at a time, and after computing an
     * encrypted version of that string, prints the encrypted
     * to the output.
     * @param input Input stream of lines to be encrypted
     * @param output Output stream of lines in encrypted form
     * @param c Cipher used to encrypt input lines
     */
    public static void encryptStream(Scanner input, PrintStream output, 
        Cipher c)
    {
        while (input.hasNext()) {
            String line = input.nextLine();
            String encryptedLine = c.encrypt(line);
            output.println(encryptedLine); 
        }
    }


    /**
     * Reads in one line of input at a time, and after computing an
     * decrypted version of that string, prints the decrypted
     * to the output.
     * @param input Input stream of lines to be decrypted
     * @param output Output stream of lines in decrypted form
     * @param c Cipher used to decrypt input lines
     */
    public static void decryptStream(Scanner input, PrintStream output, 
        Cipher c)
    {
        while (input.hasNext()) {
            String line = input.nextLine();
            String decryptedLine = c.decrypt(line);
            output.println(decryptedLine); 
        }
    }
}
