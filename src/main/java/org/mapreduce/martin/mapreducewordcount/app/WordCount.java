/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mapreduce.martin.mapreducewordcount.app;

import ch.qos.logback.classic.Logger;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.mapreduce.martin.mapreducewordcount.algorithms.Mapping;
import org.mapreduce.martin.mapreducewordcount.algorithms.Reduce;
import org.mapreduce.martin.mapreducewordcount.algorithms.Shuffling;
import org.mapreduce.martin.mapreducewordcount.algorithms.Splitting;
import org.mapreduce.martin.mapreducewordcount.util.ObjectFactory;
import org.slf4j.LoggerFactory;

/**
 *
 * @author BRIGHTER AGYEMANG
 */
public class WordCount
{
    private static Logger logger = (Logger) LoggerFactory.getLogger(WordCount.class);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // Splitting
        Splitting splitting = ObjectFactory.createSplittingObject();
        String[] linesStr;
        linesStr = splitting.splitFileContent();            
        
        //Mapping        
        ExecutorService e = Executors.newFixedThreadPool(linesStr.length);
        for (final String line : linesStr) {
            e.submit(new Runnable() {

                @Override
                public void run() 
                {  
                    Mapping mapping = ObjectFactory.createMappingObject();
                    Map<String, Integer> wordsTallyMap = mapping.perfromMapping(line);
                    
                    //Shuffling
                    for(String word : wordsTallyMap.keySet())
                    {
                        Shuffling shuffling = ObjectFactory.createShufflingObject();
                        int frequency = wordsTallyMap.get(word);
                        for(int i=0; i<frequency; i++)
                        {
                            shuffling.add(word);
                        }
                    }
                }
            });
        }
        e.shutdown();
        
        //Reduce
        while(!e.isTerminated()){}//waits for all tasks to be completed
        Shuffling shuffling = ObjectFactory.createShufflingObject();
        Collection<String> shuffledData = shuffling.getShuffledData();
        Reduce reduce = ObjectFactory.createReduceObject();
        Map<String, Integer> reducedData = reduce.performReduce(shuffledData);
        for(String word : reducedData.keySet())
        {
            System.out.println(word+", "+reducedData.get(word));
        }
    }
}
