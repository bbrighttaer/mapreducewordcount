/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mapreduce.martin.mapreducewordcount.algorithms;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author BRIGHTER AGYEMANG
 */
public class Reduce 
{
    private final Map<String, Integer> reduceData;

    public Reduce() {
        this.reduceData = new HashMap<>();
    }
    
    public Map<String, Integer> performReduce(Collection<String> shuffledData)
    {
        for(String word : shuffledData)
        {
            processData(word, shuffledData);
        }
        
        return reduceData;
    }
    
    private void processData(String word, Collection<String> shuffledData)
    {
        if(reduceData.containsKey(word))
        {
            int counter = 0;
            for(String w : shuffledData)
            {
                if(word.equalsIgnoreCase(w))
                {
                    counter++;
                }
            }
            reduceData.put(word, counter);
        }
        else
        {
            reduceData.put(word, 0);
            processData(word, shuffledData);
        }
    }
}
