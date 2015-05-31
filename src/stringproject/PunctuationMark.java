/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringproject;

/**
 * Class for storing pnctuation marks as sentence's element. 
 * 
 * @author margarita
 */
public class PunctuationMark {
    
    private final char s;
    private final int place; // after which word

    /**
     * Class constructor
     * 
     * @param s character which contains punctuation mark
     * @param place index of the last word before this mark 
     */
    public PunctuationMark(char s, int place) {
        this.s = s;
        this.place = place;
    }

    public char getS() {
        return s;
    }

    public int getPlace() {
        return place;
    }
    
    
    
}
