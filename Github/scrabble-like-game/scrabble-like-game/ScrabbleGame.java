//Jonathan Her Anthony Rocci Ashton Jantz Ping Hsuan-Teng
//10/8/24

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

public class ScrabbleGame {

    public static ArrayList<Word> words = new ArrayList<Word>();
    public static String randomLetters = "";
    public static char[] alphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'X', 'Y', 'Z' };

    public static void main(String[] args) {
        // Read in legal words file
        Scanner input = null;
        try {
            input = new Scanner(new File("Collins Scrabble Words (2019).txt"));
        } catch (FileNotFoundException e) {
            // file not found
            System.out.println("file not found");
            e.printStackTrace();
        } // end catch

        // reading in the header
        input.nextLine();
        input.nextLine();

        while (input.hasNext()) {
            words.add(new Word(input.nextLine()));
        }

        for (int i = 0; i < 4; i++) {
            getRandomLetters(); // Choose 4 random letters for hand
        }

        Scanner scnr = new Scanner(System.in);
        System.out.println("Your letters are: " + randomLetters);
        String wordChoice = scnr.nextLine().toUpperCase();
        for (int i = 0; i < wordChoice.length(); i++) {
            // if (!(wordChoice.charAt(i) == (randomLetters.charAt(i)))) {
            if (!(randomLetters.contains(wordChoice.charAt(i) + ""))) {
                System.out.println(
                        "You can't use one or more of those letters. Use the letters provided: " + randomLetters);
            } else {
                System.out.println("Success");
            }
        } // end for
        scnr.close();
        // binary search

    }// end main

    // Binary Search to check if chosen word is legal
    public static int binarySearch(String key) {
        int low = 0;
        int high = words.size() - 1;
        while (high >= low) {
            int mid = (high + low) / 2;
            if (words.get(mid).getWord().compareTo(key) > 0) {
                low = mid + 1;
            } else if (words.get(mid).getWord().compareTo(key) < 0) {
                high = mid - 1;
            } else {
                return mid;
            }

        } // end while
        return -1;
    }// end binarySearch

    // choosing 4 random letters
    public static String getRandomLetters() {
        Random rand = new Random();
        int randomIndex = rand.nextInt(alphabet.length);
        randomLetters += alphabet[randomIndex];
        return randomLetters;
    }// end getRandomLetters
}// end
