/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mapreduce.martin.mapreducewordcount.app;

import org.mapreduce.martin.mapreducewordcount.algorithms.Splitting;
import org.mapreduce.martin.mapreducewordcount.util.ObjectFactory;

/**
 *
 * @author BRIGHTER AGYEMANG
 */
public class WordCount
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Splitting splitting = ObjectFactory.creatSplittingObject();
        String[] linesStr;
        linesStr = splitting.splitFileContent();
        for (String linesStr1 : linesStr) {
            System.out.println(linesStr1);
        }
    }
    
}
