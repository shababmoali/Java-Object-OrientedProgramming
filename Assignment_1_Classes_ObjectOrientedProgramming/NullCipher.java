/**
 * NullCipher
 * Created for CSC115 Assignment One.
 */

public class NullCipher implements Cipher {
    public NullCipher(String key) {
    }
   
    /**
     * This implementation of the interface is meant to simply
     * echo parameters passed in for input and to ensure the
     * EncryptDecryptText program compiles for students.
     * @param plainText The text to be encrypted.
     * @return The same string passed in.
     */
    public String encrypt(String plainText) {
        return plainText;
    }

    /**
     * This implementation of the interface is meant to simply
     * echo parameters pass in for input and to ensure the
     * EncryptDecryptText program compiles for students.
     * @param cipherText The text to be decrypted.
     * @return The same string passed in.
     */
    public String decrypt(String cipherText) {
        return cipherText;
    }

    /**
     * Establishes the key to be used by the Cipher. This
     * version, however, does nothing with the string passed in.
     * @param key A plain text key.
     */
    public void setKey(String key) {
    }
}
