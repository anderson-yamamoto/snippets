package com.atto.challenges;

import java.util.HashMap;

//https://projecteuler.net/problem=45
public class TriangleNumber
{
    public static void main(String[] args)
    {
        int max = 500000;
        HashMap<Long, Long> hash3 = getTriangleNumbers(max);
        HashMap<Long, Long> hash5 = getPentagonalNumbers(max);
        
        for (long i = 1; i < max; i++)
        {
            Long function = (2 * i * i - i);
            if (hash3.get(function) != null & hash5.get(function) != null )
                System.out.println("Found:" + function + "-" + i);
        }
    }

    public static HashMap<Long, Long> getTriangleNumbers(int upTo)
    {
        HashMap<Long, Long> hash = new HashMap<Long, Long>();
        for (long i = 1; i < upTo + 1; i++)
        {
            Long function = (i * i + i) / 2;
            hash.put(function, function);
        }
        return hash;
    }

    public static HashMap<Long, Long> getPentagonalNumbers(int upTo)
    {
        HashMap<Long, Long> hash = new HashMap<Long, Long>();
        for (long i = 1; i < upTo + 1; i++)
        {
            Long function = (3l * i * i - i) / 2;
            hash.put(function, function);
        }
        return hash;
    }
}
