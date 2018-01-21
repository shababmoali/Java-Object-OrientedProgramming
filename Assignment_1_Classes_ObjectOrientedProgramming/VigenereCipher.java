import java.util.*;

public class VigenereCipher {
  
  String key;
	
	
	//constructor
	public VigenereCipher(String key) {
		this.key = key;
	} 
	
	
	// Sets the key for a simplified Vigenere cipher.
	public void	setKey(String key) {
		this.key = key;
	}
	
	
	// Encrypts a string using a simplified Vigenere cipher.
	public String encrypt(String plaintext) {
		return null;
	}
	
	
	// Decrypts a string using a modified Vigenere cipher.
	public String decrypt(String ciphertext) {
		return null;
	}
	
	
	// Converts an array of integers with values in the range 0...25 
	// into a string with characters in the range a...z.
	private String intArrayToString(int[] encodedText) {
		
		String result = "";
		for (int i: encodedText) {
			char c = (char)(i + 97);
			result += c;
		}
		return result;
	
	}
	
	
	// Converts a string into an int array where the values are within the range 0...25.
	private int[] stringToIntArray(String text) {
		
		int[] result = new int[text.length()];
		for (int i=0; i<text.length(); i++) {
            result[i] = (int)text.charAt(i) - 97;

        }
		return result;
	
	}
	
	
	// dumpArray(int[] array, String text) - Prints out the specified text, 
	// followed immediately by the (comma-delimited) contents of the array.
	private void dumpArray(int[] array, String text) {
		
		String s = text;
		System.out.println(s);
		for (int i=0; i<array.length; i++) {
			System.out.print(i);
			if (i != array.length-1) {
				System.out.print(",");
			} 
		}

	} //end dumpArray(int[] array, String text)  
	
	
	// main(String[] args) used for internal testing purposes only.
	public static void main(String[] args) {
		
		// Test constructor
		VigenereCipher vc = new VigenereCipher("obo");
		System.out.println("\nConstruct VigenereCipher object with key:");
		System.out.println(vc.key);
		
		
		// Test setKey class method:
		vc.setKey("bob");
		System.out.println("setKey(\"bob\") Test:");
		System.out.println(vc.key + "\n");
		
		
		// Test private int[] stringToIntArray(String textdcn):
		System.out.println("Test private int[] stringToIntArray(String textdcn):");
		String sTIA = "";
		for(char i='a'; i<='z'; i++) {
			sTIA += i;
		}
		System.out.println(sTIA);		
		System.out.println(Arrays.toString(vc.stringToIntArray(sTIA)) + "\n");
		
		
		// Test private String intArrayToString(int[] encodedText):
		System.out.println("Test private String intArrayToString(int[] encodedText):");
		int[] t = new int[26];
		for(int i=0; i<26; i++) {
			t[i] = i;
		}
		System.out.println(Arrays.toString(t));
		System.out.println(vc.intArrayToString(t) + "\n");
		
		
		// Test private void dumpArray(int[] array, String text):
		System.out.println("Test private void dumpArray(int[] array, String text):");		
		String s = "text: ";
		System.out.println(s);
		for (int i=0; i<4; i++) {

			System.out.print(i);
		}
		vc.dumpArray(t, s);
		
	} // end main(String[] args)
	
	
} // end class VigenereCipher