/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mapreduce.martin.mapreducewordcount.app;

import ch.qos.logback.classic.Logger;
import java.util.Map;
import org.mapreduce.martin.mapreducewordcount.algorithms.Mapping;
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
        logger.info("-------------BEGIN SPLITTING-------------------");
        Splitting splitting = ObjectFactory.creatSplittingObject();
        String[] linesStr;
        linesStr = splitting.splitFileContent();
        for (String linesStr1 : linesStr) {
            System.out.println(linesStr1);
        }
        logger.info("-------------END SPLITTING-------------------");     
        
        System.out.println("");
        
        
        //Mapping        
        logger.info("-------------BEGIN MAPPING-------------------");
        Mapping mapping = ObjectFactory.creatMappingObject();
        Map<String, Integer> wordsTallyMap = mapping.perfromMapping(linesStr[0]);
        System.out.println("wordsTallyMap: "+wordsTallyMap.size());
        for(String word : wordsTallyMap.keySet())
        {
            System.out.println(word+", "+wordsTallyMap.get(word));
        }
        logger.info("-------------END SPLITTING-------------------");
    }
}
