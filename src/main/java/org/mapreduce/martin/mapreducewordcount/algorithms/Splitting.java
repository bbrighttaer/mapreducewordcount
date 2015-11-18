/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mapreduce.martin.mapreducewordcount.algorithms;

import ch.qos.logback.classic.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import org.apache.commons.io.IOUtils;
import org.mapreduce.martin.mapreducewordcount.util.FileLoader;
import org.mapreduce.martin.mapreducewordcount.util.ObjectFactory;
import org.slf4j.LoggerFactory;

/**
 *
 * @author BRIGHTER AGYEMANG
 */
public class Splitting 
{
    private static final Logger logger = (Logger) LoggerFactory.getLogger(Splitting.class);
    private final FileLoader fileLoader;
    private final String txt_filename = "/words_2.txt";
    private final String splittingDelimiter = "\n";

    public Splitting() {
        this.fileLoader = ObjectFactory.createFileLoaderObject();
    }
    
    public String[] splitFileContent()
    {        
        return getFileContents().split(splittingDelimiter);
    }
    
    /**
     * Loads the specified text file and returns its content if it
     * is not null
     * @return The contents of the file
     */
    private String getFileContents()
    {
        String words = null;
        try 
        {
            InputStream filestream = this.fileLoader.loadTextFile(txt_filename);
            StringWriter writer = new StringWriter();
            IOUtils.copy(filestream, writer, "utf-8");
            words = writer.toString();
        } catch (IOException ex) {
            logger.error(ex.toString());
        }
        return words;
    }
    
}
