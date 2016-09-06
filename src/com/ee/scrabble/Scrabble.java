package com.ee.scrabble;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Vishal on 05-09-2016.
 */
public class Scrabble {
    private static Scrabble onlyInstanceOfScrabble;
    private CharBoxForScrabble charBox = null;
    List<Character> characterList;

    private  Scrabble(){

        charBox = new CharBoxForScrabble();
        //charBox = getAlphabetsForGame();
    }

//    private CharBoxForScrabble getAlphabetsForGame() {
//
//        return new CharBoxForScrabble();
//    }

    public static synchronized Scrabble getInstance(int numberOfChars) {
        synchronized (Scrabble.class){
            if(onlyInstanceOfScrabble ==null){
                onlyInstanceOfScrabble = new Scrabble();
            }
            onlyInstanceOfScrabble.characterList = new LinkedList<>();
            onlyInstanceOfScrabble.characterList = onlyInstanceOfScrabble.charBox.getStreamOfCharsToPlay(numberOfChars);

        }

        return onlyInstanceOfScrabble;
    }
}
