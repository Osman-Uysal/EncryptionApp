package org.example;

public class VigenereCipher {
    public static String encrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        int textLen = text.length();
        int keyLen = key.length();

        for (int i = 0; i < textLen; i++) {
            char character = text.charAt(i);
            char keyChar = key.charAt(i % keyLen);

            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                character = (char) (((character - base + keyChar - base) % 26) + base);
            }

            result.append(character);
        }

        return result.toString();
    }

    public static String decrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        int textLen = text.length();
        int keyLen = key.length();

        for (int i = 0; i < textLen; i++) {
            char character = text.charAt(i);
            char keyChar = key.charAt(i % keyLen);

            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                character = (char) (((character - base - (keyChar - base) + 26) % 26) + base);
            }

            result.append(character);
        }

        return result.toString();
    }


}

