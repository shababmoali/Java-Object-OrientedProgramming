//import java.util.Arrays;

public class VigenereCipher {
  
  String key;
  int[] intCipherKey;
	
	
	//constructor
	public VigenereCipher(String key) {
		this.key = key;
		this.intCipherKey = stringToIntArray(this.key);
	} 
	
	
	
	// public void	setKey(String key) - Sets the key for a simplified Vigenere cipher.
	public void	setKey(String key) {
		this.key = key;
		this.intCipherKey = stringToIntArray(this.key);
	}
	
	
	
	// public String encrypt(String plaintext) - 
	// Encrypts a string using a simplified Vigenere cipher via intCipherKey attribute.
	public String encrypt(String plaintext) {
		
		int[] intTextInput = stringToIntArray(plaintext);
		int[] encryptedIntOutput = new int[intTextInput.length];
		
		for (int i=0; i<encryptedIntOutput.length; i++) {
			encryptedIntOutput[i] = ( intTextInput[i] + (this.intCipherKey[i%this.intCipherKey.length]) ) % 26;		
		}
		
		String result = intArrayToString(encryptedIntOutput);
		
		return result;
	
	} //end encrypt(String plaintext)
	
	
	
	// public String decrypt(String ciphertext) - 
	// Decrypts a string using a modified Vigenere cipher via intCipherKey attribute.
	public String decrypt(String ciphertext) {
		
		int[] intCipherText = stringToIntArray(ciphertext);
		int[] decryptedIntOutput = new int[intCipherText.length];
		
		for (int i=0; i<decryptedIntOutput.length; i++) {
			decryptedIntOutput[i] = ( 26 + intCipherText[i] - (this.intCipherKey[i%this.intCipherKey.length]) ) % 26;		
		}
		
		String result = intArrayToString(decryptedIntOutput);
		
		return result;
		
	} //end decrypt(String ciphertext)
	
	
	
	// private String intArrayToString(int[] encodedText) - 
	// Converts an array of integers with values in the range 0...25 
	// into a string with characters in the range a...z.
	private String intArrayToString(int[] encodedText) {
		
		String result = "";
		for (int i: encodedText) {
			char c = (char)(i + 97);
			result += c;
		}
		return result;
	
	} //end intArrayToString(int[] encodedText)
	
	
	
	// private int[] stringToIntArray(String text) - 
	// Converts a string into an int array where the values are within the range 0...25.
	private int[] stringToIntArray(String text) {
		
		int[] result = new int[text.length()];
		for (int i=0; i<text.length(); i++) {
            result[i] = (int)text.charAt(i) - 97;

        }
		return result;
	
	} //end stringToIntArray(String text)
	
	
	
	// private void dumpArray(int[] array, String text) - Prints out the specified text, 
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
		System.out.println();
		
	} //end dumpArray(int[] array, String text)  
	
	
	
	// main(String[] args) used for internal testing purposes only.
	// UNDO BLOCK COMMENTS and *import java.util.Arrays TO IMPLEMENT!

	public static void main(String[] args) {
/*	
		// Test constructor
		VigenereCipher vc = new VigenereCipher("obo");
		System.out.println("\nConstruct VigenereCipher object with key:");
		System.out.println(vc.key);
		
		
		// Test setKey class method:
		vc.setKey("bob");
		System.out.println("setKey(\"bob\") Test:");
		System.out.println(vc.key + "\n");
		
		
		// Test private int[] stringToIntArray(String textdcn):
		System.out.println("Test private int[] stringToIntArray(String text):");
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
		vc.dumpArray(t, s);
		System.out.println();
		
		
		// Test public String encrypt(String plaintext):
		System.out.println("Test VigenereCipher encrypt() and decrypt():");		
		System.out.println("Encrypt: 'themessage' with key 'bob':");
		String encryptTest = "themessage";
		System.out.println(vc.encrypt(encryptTest));
		
		
		// Test public String decrypt(String ciphertext):
		System.out.println("Decrypt:");
		String decryptTest = vc.decrypt(vc.encrypt(encryptTest));
		System.out.println(decryptTest);
*/		
	} //end main(String[] args)

	
} //end class VigenereCipher