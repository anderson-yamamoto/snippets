package com.atto.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/*
 * You have a list of weights, and a drone can take two items at most, for a maximum combined weight of 100kg. 
 * Calculate the minimum number of trips required to transport all items. 
 */
public class Weight
{
    private static final int MARKED_FOR_DELIVERY = 1;

    public static void main(String[] args)
    {
        minimumNumberOfTrips(100, new int[]{5,10, 20, 30, 40, 50,55,65,75,77,81,88,90,97});
        //new int[]{70,10, 20, 30, 40, 50,35,45,15,22,31,40,90,27});
    }

    static int minimumNumberOfTrips(int tripMaxWeight, int[] packagesWeight)
    {
        int trips = 0;
        int[] flagArray = new int[packagesWeight.length];
        List<Integer> listOfWeights = new ArrayList<Integer>();
        for (int i = 0; i < packagesWeight.length; i++)
        {
            listOfWeights.add(packagesWeight[i]);
        }
        Collections.sort(listOfWeights);
        

        for (int i = listOfWeights.size() - 1; i >= 0; i--)
        {
            if (flagArray[i] == MARKED_FOR_DELIVERY) continue;
            
            
            Integer index = findClosestWeightIndex(listOfWeights, tripMaxWeight - listOfWeights.get(i), flagArray);
            System.out.println("For " + listOfWeights.get(i) + "-Found" + index + " " + flagArray[i]);
            
            
            if (index > -1)
            {
                System.out.println("Found match: " + listOfWeights.get(index));
                flagArray[index] = MARKED_FOR_DELIVERY;
            }
            flagArray[i] = MARKED_FOR_DELIVERY;
            System.out.println(Arrays.toString(flagArray));
            trips++;
        }
        System.out.println(Arrays.toString(flagArray));
        System.out.println(trips);
        
        return trips;
    }

    private static Integer findClosestWeightIndex(List<Integer> listOfWeights, int requiredWeight, int[] flagArray)
    {
        int i = 0;
        int lastUnmarked = -1;
        for (; i < listOfWeights.size(); i++)
        {
            if (requiredWeight < listOfWeights.get(i)) 
                return lastUnmarked;
            if (flagArray[i] != MARKED_FOR_DELIVERY )
                lastUnmarked = i;
        }
        return lastUnmarked;
    }
}
