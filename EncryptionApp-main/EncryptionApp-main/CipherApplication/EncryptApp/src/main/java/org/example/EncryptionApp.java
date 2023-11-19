package org.example;

import java.util.Scanner;


public class EncryptionApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an option:");
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        int operationChoice = scanner.nextInt();
        scanner.nextLine(); 

        switch (operationChoice) {
            case 1:
                System.out.println("Enter the text to encrypt:");
                String textToEncrypt = scanner.nextLine();

                System.out.println("Choose a cipher:");
                System.out.println("a. Caesar Cipher");
                System.out.println("b. Vigenere Cipher");
                System.out.println("c. Rail Fence Cipher");
                char cipherChoice = scanner.nextLine().charAt(0);

                switch (cipherChoice) {
                    case 'a':
                        System.out.println("Enter the shift value for Caesar Cipher:");
                        int caesarShift = scanner.nextInt();
                        scanner.nextLine();
                        String caesarEncrypted = CaesarCipher.encrypt(textToEncrypt, caesarShift);
                        System.out.println("Encrypted Result (Caesar Cipher): " + caesarEncrypted);
                        break;
                    case 'b':
                        System.out.println("Enter the key for Vigenère Cipher:");
                        String vigenereKey = scanner.nextLine();
                        String vigenereEncrypted = VigenereCipher.encrypt(textToEncrypt, vigenereKey);
                        System.out.println("Encrypted Result (Vigenère Cipher): " + vigenereEncrypted);
                        break;
                    case 'c':
                        System.out.println("Enter the number of rails for Rail Fence Cipher:");
                        int railFenceRails = scanner.nextInt();
                        scanner.nextLine();
                        String railFenceEncrypted = RailFenceCipher.encrypt(textToEncrypt, railFenceRails);
                        System.out.println("Encrypted Result (Rail Fence Cipher): " + railFenceEncrypted);
                        break;
                    default:
                        System.out.println("Invalid cipher choice!");
                        break;
                }
                break;
            case 2:
                System.out.println("Enter the text to decrypt:");
                String textToDecrypt = scanner.nextLine();

                System.out.println("Choose a cipher for decryption:");
                System.out.println("a. Caesar Cipher");
                System.out.println("b. Vigenère Cipher");
                System.out.println("c. Rail Fence Cipher");
                char decryptCipherChoice = scanner.nextLine().charAt(0);

                switch (decryptCipherChoice) {
                    case 'a':
                        System.out.println("Enter the shift value for Caesar Cipher:");
                        int caesarShift = scanner.nextInt();
                        scanner.nextLine();
                        String caesarDecrypted = CaesarCipher.decrypt(textToDecrypt, caesarShift);
                        System.out.println("Decrypted Result (Caesar Cipher): " + caesarDecrypted);
                        break;
                    case 'b':
                        System.out.println("Enter the key for Vigenère Cipher:");
                        String vigenereKey = scanner.nextLine();
                        String vigenereDecrypted = VigenereCipher.decrypt(textToDecrypt, vigenereKey);
                        System.out.println("Decrypted Result (Vigenère Cipher): " + vigenereDecrypted);
                        break;
                    case 'c':
                        System.out.println("Enter the number of rails for Rail Fence Cipher:");
                        int railFenceRails = scanner.nextInt();
                        scanner.nextLine();
                        String railFenceDecrypted = RailFenceCipher.decrypt(textToDecrypt, railFenceRails);
                        System.out.println("Decrypted Result (Rail Fence Cipher): " + railFenceDecrypted);
                        break;
                    default:
                        System.out.println("Invalid cipher choice!");
                        break;
                }
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }
}
