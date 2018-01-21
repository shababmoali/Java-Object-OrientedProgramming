/*
* Name: <your names goes here>
* ID: <your identification number goes here>
* Date: <date of last modification goes here>
* Filename: <Classname>.java
* Details: \course\ Assignment <number>
*/



/**
 * Cipher.java 
 * Created for CSC115 Assignment One.
 */

/**
 * An interface implemented by all Cipher classes that use a key 
 * on plain text, both for encrypting and decrypting.
 */
public interface Cipher {

    /**
     * Converts plain text to cipher text.
     * @param plainText The text to be encrypted.
     * @return the ciphertext.
     */
    public String encrypt(String plainText);

    /**
     * Converts cipher text to plain text.
     * @param cipherText The previously encrypted text.
     * @return the plain text, decrypted.
     */
    public String decrypt(String cipherText);

    /**
     * Sets the key to be used by the Cipher, especially if this needs
     * to change during the life of a Cipher object (i.e., the
     * constructor already establishes the key when a Cipher object
     * is first created).
     * @param key A plain text key.
     */
    public void setKey(String key);
}
