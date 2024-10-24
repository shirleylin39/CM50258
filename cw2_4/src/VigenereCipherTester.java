
public class VigenereCipherTester {


    public static void main(String[] args) {
        VigenereCipher vigenereCipher = new VigenereCipher();

        // Encrypt a message from 'encrypt_check.txt' using the key in 'key_check.txt'
        String encrypted = vigenereCipher.encrypt("src/encrypt_check.txt", "src/key_check.txt");
        System.out.println("Encrypted Message: " + encrypted);

        // Decrypt a message from 'decrypt_check.txt' using the key in 'key_check.txt'
        String decrypted = vigenereCipher.decrypt("src/decrypt_check.txt", "src/key_check.txt");
        System.out.println("Decrypted Message: " + decrypted);
    }
}