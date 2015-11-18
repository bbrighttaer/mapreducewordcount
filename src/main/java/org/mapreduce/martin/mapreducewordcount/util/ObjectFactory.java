/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mapreduce.martin.mapreducewordcount.util;

import org.mapreduce.martin.mapreducewordcount.algorithms.Mapping;
import org.mapreduce.martin.mapreducewordcount.algorithms.Reduce;
import org.mapreduce.martin.mapreducewordcount.algorithms.Shuffling;
import org.mapreduce.martin.mapreducewordcount.algorithms.Splitting;

/**
 *
 * @author BRIGHTER AGYEMANG
 */
public class ObjectFactory 
{

    public ObjectFactory() {
    }
    
    public static FileLoader createFileLoaderObject()
    {
        return new FileLoader();
    }
    
    public static Splitting createSplittingObject()
    {
        return new Splitting();
    }
    
    public static Mapping createMappingObject()
    {
        return new Mapping();
    }
    
    public static Shuffling createShufflingObject()
    {
        return new Shuffling();
    }
    
    public static Reduce createReduceObject()
    {
        return new Reduce();
    }
}
