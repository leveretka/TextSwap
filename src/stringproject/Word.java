/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringproject;

/**
 * Class for storing words as sentence's element. 
 * 
 * @author margarita
 */
public class Word {
    
    private final String source;

    /**
     * Class constructor.
     * 
     * @param source String contains exactly this word 
     */
    public Word(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return source;
    }
    
    
}
