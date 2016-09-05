package com.ee.scrabble;

/**
 * Created by Vishal on 05-09-2016.
 */
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class CharBoxForScrabble {
    private final int MAX_CHARS_IN_BOX = 50;
    private List<Character> boxOfchars;

    public CharBoxForScrabble() {
        fillCharBox();
    }

    private void fillCharBox() {
        this.boxOfchars = new LinkedList<>();
        addRandomCharsToBoxOfChars();
    }

    private void addRandomCharsToBoxOfChars() {
        Random randomObject = new Random();
        for (int boxIterator = 0; boxIterator < MAX_CHARS_IN_BOX; boxIterator++) {
            this.boxOfchars.add((char)('a' + randomObject.nextInt(26)));
        }
    }

    public char[] getStreamOfCharsToPlay(int requestedNumberOfChars) {

        if(this.boxOfchars.size()<requestedNumberOfChars){
            throw new IllegalArgumentException("Request fewer than "+this.boxOfchars.size());
        }
        Random randomObject = new Random();
        char[] resultantCharArray = new char[requestedNumberOfChars];
        int numberOfCharsInResultantCharArray = 0;
        while (numberOfCharsInResultantCharArray < requestedNumberOfChars) {
            int randomNumber = randomObject.nextInt(this.boxOfchars.size()-1);
            resultantCharArray[numberOfCharsInResultantCharArray] = this.boxOfchars.get(randomNumber);
            removeCharFromBox(randomNumber);
            numberOfCharsInResultantCharArray++;
        }
        return resultantCharArray;
    }

    private void removeCharFromBox(int indexOfcharacter) {
        this.boxOfchars.remove(indexOfcharacter);
    }

    @Override
    public String toString() {
        return (this.boxOfchars).toString();
    }
}