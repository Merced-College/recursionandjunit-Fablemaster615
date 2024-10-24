import java.io.*;
import java.util.*;

//The word class represents a word in the game
//It implements Comparable<Word> to enable sorting and searching
public class Word implements Comparable<Word> {
    // the word to be represented by the class
    private String word;

    public Word(String word) {
        this.word = word;
        // Getter method to retrieve the word
    }

    public String getWord() {
        return word;
    }

    // override the compareTo method to compare two method objects based on the
    // actual word
    public int compareTo(Word other) {
        return this.word.compareTo(other.word);
    }

}