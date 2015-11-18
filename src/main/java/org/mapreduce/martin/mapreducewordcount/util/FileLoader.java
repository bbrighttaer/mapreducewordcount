/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mapreduce.martin.mapreducewordcount.util;

import java.io.InputStream;

/**
 *
 * @author BRIGHTER AGYEMANG
 */
public class FileLoader 
{

    public FileLoader() {
    }
    
    public InputStream loadTextFile(String filename)
    {
        return this.getClass().getResourceAsStream(filename);
    }
}
