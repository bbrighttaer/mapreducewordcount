/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mapreduce.martin.mapreducewordcount.util;

import org.mapreduce.martin.mapreducewordcount.algorithms.Mapping;
import org.mapreduce.martin.mapreducewordcount.algorithms.Splitting;

/**
 *
 * @author BRIGHTER AGYEMANG
 */
public class ObjectFactory 
{

    public ObjectFactory() {
    }
    
    public static FileLoader creatFileLoaderObject()
    {
        return new FileLoader();
    }
    
    public static Splitting creatSplittingObject()
    {
        return new Splitting();
    }
    
    public static Mapping creatMappingObject()
    {
        return new Mapping();
    }
}
