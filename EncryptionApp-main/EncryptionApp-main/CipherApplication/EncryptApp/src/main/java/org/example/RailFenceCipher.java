package org.example;

public class RailFenceCipher {
    // Encrypts text using the Rail Fence Cipher with a given number of rails
    public static String encrypt(String text, int rails) {
        StringBuilder[] fences = new StringBuilder[rails];
        for (int i = 0; i < rails; i++) {
            fences[i] = new StringBuilder();
        }

        int currentRail = 0;
        boolean down = true;

        for (char character : text.toCharArray()) {
            fences[currentRail].append(character);
            if (currentRail == 0) {
                down = true;
            } else if (currentRail == rails - 1) {
                down = false;
            }

            if (down) {
                currentRail++;
            } else {
                currentRail--;
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder rail : fences) {
            result.append(rail);
        }

        return result.toString();
    }

    // Decrypts text encrypted with the Rail Fence Cipher using the given number of rails
    public static String decrypt(String text, int rails) {
        StringBuilder result = new StringBuilder();
        int textLength = text.length();
        int cycle = 2 * (rails - 1);

        for (int i = 0; i < rails; i++) {
            int step = 2 * i;
            for (int j = i; j < textLength; j += cycle) {
                result.append(text.charAt(j));
                step = cycle - step;
                if (step == cycle) {
                    step = 0;
                }
            }
        }

        return result.toString();
    }


}
