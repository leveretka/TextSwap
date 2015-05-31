/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringproject;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for storing sentence as parsed construction. 
 * 
 * @author margarita
 */
public class Sentence {
    
    private String source;
    
    private List<Word> words = new ArrayList<>();
    private List<PunctuationMark> marks = new ArrayList<>();
    private SentenceType type;
    
    /**
     * Class constructor.
     * 
     * @param source String which contains the sentence
     * @param type type of sentence
     */
    public Sentence(String source, SentenceType type) {
        this.source = source.trim();
        this.type = type;
        parse();
    }
    
    /**
     * Method that finds substrings of source 
     * containing exactly one word or punctuation
     * mark in order to convert it to appropriate
     * type and fill the list of words and
     * punctuation marks. 
     */
    private void parse() {
        
        char first = source.charAt(0);
        
        while (("" + first).matches(/*"[,;-\\:\'\"\\(\\)]"*/ "[,;]")) {
            marks.add(new PunctuationMark(first, -1));
            source = source.substring(0, source.length() - 1);
            first = source.charAt(0);
        }
        
        String temp = source.replaceAll("[.!?]", "");
        String [] words = temp.split("\\s");
        for (int i = 0; i < words.length; ++i) {
            char ch = words[i].charAt(words[i].length() - 1); 
            while (("" + ch).matches(/*"[,;-\\:\'\"\\(\\)]"*/ "[,;]")) {
                marks.add(0,new PunctuationMark(ch, i));
                words[i] = words[i].substring(0, words[i].length() - 1);
                ch = words[i].charAt(words[i].length() - 1);
            }
            
            this.words.add(new Word(words[i]));
        }
        
    }
    
    /**
     * This method restors source String
     * from list of Words and PunctuationMarks.
     */

    private void update() {
        String result = "";
        for (PunctuationMark p: marks) {
            if (p.getPlace() == -1) {
                result += p.getS();
            }
        }
        for (int i = 0; i < words.size(); ++i) {
            result += words.get(i).toString();
            for (PunctuationMark p: marks) {
                if (p.getPlace() == i) {
                    result += p.getS();
                }
            }
            if (i != words.size() - 1) {
                result += " ";
            }
        }
        if (type == SentenceType.NARRATIVE) {
            result += ".";
        }
        if (type == SentenceType.INTERROGATIVE) {
            result += "?";
        }
        if (type == SentenceType.EXCLAMATORY) {
            result += "!";
        }
        source = result;
    }
    
    /**
     * Method that swaps first and last word
     * in this sentence.
     */
    public void swapfirstLast() {
        if (words.size() == 1) {
            return;
        }
        Word start = words.get(0);
        words.remove(0);
        int last = words.size() - 1;
        Word end = words.get(last);
        words.remove(last);
        words.add(start);
        words.add(0, end);
        update();
    }
    
    
   /**
     * This method gives String representation
     * of this sentence.
     * 
     * @return String containing the whole Sentence 
     */
 
    @Override
    public String toString() {
        return source;
    }
   
    public static enum SentenceType {NARRATIVE, INTERROGATIVE, EXCLAMATORY};
    
}
