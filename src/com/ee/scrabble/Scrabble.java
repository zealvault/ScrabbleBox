package com.ee.scrabble;

/**
 * Created by Vishal on 05-09-2016.
 */
public class Scrabble {
    private static Scrabble onlyInstanceOfScrabble;
    private CharBoxForScrabble charBox = null;


    private  Scrabble(){

        charBox = getAlphabetsForGame();
    }

    private CharBoxForScrabble getAlphabetsForGame() {

        return new CharBoxForScrabble();
    }

    public synchronized static Scrabble getInstance() {
        if(onlyInstanceOfScrabble ==null){
            onlyInstanceOfScrabble = new Scrabble();
        }
        return onlyInstanceOfScrabble;
    }

}
