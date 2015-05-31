/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringproject;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class for storing text composed of sentences.
 * Gives opportunity to manipulate its senteces.
 * 
 * @author margarita
 */
public class Text {
    private String source;
    private List<Sentence> sentences = new ArrayList<>();

    /**
     * Class constructor.
     * 
     * @param source the whole text, which contains some sentences 
     */
    public Text(String source) {
        this.source = source;
        parse();
    }
    
    /**
     * Method that finds substrings of source 
     * containing exactly one sentence in order
     * to convert it to Sentence and fill the
     * list of sentences. 
     */
    private void  parse() {
        Pattern any = Pattern.compile("[^.!?]*[\\?\\.\\!]");
        String narr = "[^.!?]+\\.";
        String inter = "[^.!?]+\\?";
        String exclam = "[^.!?]+\\!";
        
        Matcher m = any.matcher(source);
        while (m.find()) {
            String temp = m.group();
            if (temp.matches(narr)) {
                sentences.add(new Sentence(temp.trim(), Sentence.SentenceType.NARRATIVE));
                continue;
            }
            if (temp.matches(inter)) {
                sentences.add(new Sentence(temp.trim(), Sentence.SentenceType.INTERROGATIVE));
                continue;
            }
            if (temp.matches(exclam)) {
                sentences.add(new Sentence(temp.trim(), Sentence.SentenceType.EXCLAMATORY));
            }
        }
    }
    
    /**
     * Method that swaps first and last word
     * in every sentence in this text.
     */
    public void swapFirstLast() {
        for (Sentence s: sentences) {
            s.swapfirstLast();
        }
        update();
    }
    
    /**
     * This method restors source String
     * from list of Sentences.
     */
    private void update() {
        String result = "";
        for (Sentence s: sentences) {
            result += s.toString();
            result += " ";
        }
        source = result;
    }

    /**
     * This method gives String representation
     * of given text.
     * 
     * @return String containing the whole text 
     */
    @Override
    public String toString() {
        return source;
    }
    
    
}
