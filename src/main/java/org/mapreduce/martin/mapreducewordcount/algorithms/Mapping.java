/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mapreduce.martin.mapreducewordcount.algorithms;

import ch.qos.logback.classic.Logger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;

/**
 *
 * @author BRIGHTER AGYEMANG
 */
public class Mapping 
{
    private static final Logger logger = (Logger) LoggerFactory.getLogger(Mapping.class);
    private final String delimiter = " ";

    public Mapping() {
    }
    
    public Map<String,Integer> perfromMapping(String line)
    {
        String[] wordsInLine = line.split(delimiter);
        Map<String,Integer> tally = new HashMap<>();
        for(String word: wordsInLine)
        {
            doTally(word, tally, wordsInLine);
        }
        return Collections.unmodifiableMap(tally);
    }
    
    /**
     * Uses recursion to count the number of times a word appears in a line
     * @param word The word
     * @param tally the data structure to hold the records
     */
    private void doTally(String word, Map<String,Integer> tally, String[] wordsInLine)
    {
        word = cleanWord(word);
        if(tally.containsKey(word))
        {
            int counter = 0;
            for(String w : wordsInLine)
            {
                w = cleanWord(w);
                if(word.equalsIgnoreCase(w))
                {
                    counter++;
                }
            }
            tally.put(word, counter);
        }
        else
        {
            tally.put(word, 0);
            doTally(word, tally, wordsInLine);
        }
    }
    
    /**
     * For cleaning a word to ensure that 
     * @param word 
     * @return  
     */
    public String cleanWord(String word)
    {
        String[] delimiters = {"\n", " ", "  ", "\r", ".", ","};
        for(String del : delimiters)
        {
            word = StringUtils.remove(word, del).trim();
        }
        return word;
    }
    
}
