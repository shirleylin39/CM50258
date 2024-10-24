import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class VigenereCipher implements Cipher {

    private static final int ALPHABET_NUMBER = 26;
    private static final char ALPHABET_START = 'A';

    private char[][] vigenereSquare;

    public VigenereCipher() {
        initializeVigenereSquare();
    }

    private void initializeVigenereSquare() {
        vigenereSquare = new char[ALPHABET_NUMBER][ALPHABET_NUMBER];

        for (int i = 0; i < ALPHABET_NUMBER; i++) {
            for (int j = 0; j < ALPHABET_NUMBER; j++) {
                vigenereSquare[i][j] = (char) ((i + j) % ALPHABET_NUMBER + ALPHABET_START);
            }
        }
    }

    private String readFromFile(String filePath) throws IOException {
        StringBuilder message = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int message_letter;
            while ((message_letter = reader.read()) != -1) {
                message.append((char) message_letter);
            }
        }
        return message.toString();
    }

    private String repeatKey(String key, int keylength) {
        if (key.isEmpty()) {
            return "";
        }

        StringBuilder keyRepeat = new StringBuilder();
        for (int i = 0; i < keylength; i++) {
            keyRepeat.append(key.charAt(i % key.length()));
        }

        return keyRepeat.toString();
    }

    @Override
    public String encrypt(String messageFilename, String keyFilename) {
        String message = "";
        String key = "";
        try {
            message = readFromFile(messageFilename).toUpperCase();
            key = readFromFile(keyFilename).toUpperCase();
        } catch (IOException exceptions) {
            exceptions.printStackTrace();
            return null;
        }

        String keyRepeat = repeatKey(key, message.length()).toUpperCase();
        StringBuilder encryptedMessage = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);
            if (Character.isAlphabetic(currentChar)) {
                int rowIndex = Character.toUpperCase(currentChar) - ALPHABET_START;
                int columnIndex = keyRepeat.charAt(i) - ALPHABET_START;
                encryptedMessage.append(vigenereSquare[rowIndex][columnIndex]);
            } else {
                encryptedMessage.append(currentChar);
            }
        }

        return encryptedMessage.toString();
    }

    @Override
    public String decrypt(String messageFilename, String keyFilename) {
        String message = "";
        String key = "";
        try {
            message = readFromFile(messageFilename).toUpperCase();
            key = readFromFile(keyFilename).toUpperCase();
        } catch (IOException exceptions) {
            exceptions.printStackTrace();
            return null;
        }

        String keyRepeat = repeatKey(key, message.length()).toUpperCase();
        StringBuilder decryptedMessage = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);
            if (Character.isAlphabetic(currentChar)) {
                int columnIndex = keyRepeat.charAt(i) - ALPHABET_START;
                int rowIndex = 0;
                while (vigenereSquare[rowIndex][columnIndex] != Character.toUpperCase(currentChar)) {
                    rowIndex = (rowIndex + 1) % ALPHABET_NUMBER;
                }
                decryptedMessage.append((char) (rowIndex + ALPHABET_START));
            } else {
                decryptedMessage.append(currentChar);
            }
        }
        return decryptedMessage.toString();
    }
}