/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mapreduce.martin.mapreducewordcount.algorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author BRIGHTER AGYEMANG
 */
public class Shuffling
{
    private static final ArrayList<String> aggregateData = new ArrayList<>();

    public Shuffling() {
    }
    
    public void add(String data)
    {
        synchronized(aggregateData)
        {
            aggregateData.add(data);
        }
    }
    
    public synchronized Collection<String> getShuffledData()
    {
        return Collections.unmodifiableCollection(aggregateData);
    }
}
