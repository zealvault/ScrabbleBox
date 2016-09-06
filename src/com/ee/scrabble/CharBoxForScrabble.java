package com.ee.scrabble;

/**
 * Created by Vishal on 05-09-2016.
 */
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class CharBoxForScrabble {
    private final int MAX_CHARS_IN_BOX = 50;
    private List<Character> boxOfChars;

    public CharBoxForScrabble() {

        fillCharBox();
    }

    private void fillCharBox() {
        this.boxOfChars = new LinkedList<>();
        addRandomCharsToBoxOfChars();
    }

    private void addRandomCharsToBoxOfChars() {
        Random randomObject = new Random();
        for (int boxIterator = 0; boxIterator < MAX_CHARS_IN_BOX; boxIterator++) {
            this.boxOfChars.add((char)('a' + randomObject.nextInt(26)));
        }
    }

    public List<Character> getStreamOfCharsToPlay(int requestedNumberOfChars) {
        List<Character> resultantListOfChars = new LinkedList<>();
        if(this.boxOfChars.size()<requestedNumberOfChars){
            throw new IllegalArgumentException("Request fewer than "+this.boxOfChars.size());
        }
        Random randomObject = new Random();
        int numberOfCharsInResultantCharArray = 0;
        while (numberOfCharsInResultantCharArray < requestedNumberOfChars) {
            int randomNumber = randomObject.nextInt(this.boxOfChars.size());
            resultantListOfChars.add(this.boxOfChars.get(randomNumber));
            removeCharFromBox(randomNumber);
            numberOfCharsInResultantCharArray++;
        }
        return resultantListOfChars;
    }

    private void removeCharFromBox(int indexOfCharacter) {
        this.boxOfChars.remove(indexOfCharacter);
    }

    @Override
    public String toString() {
        return (this.boxOfChars).toString();
    }
}