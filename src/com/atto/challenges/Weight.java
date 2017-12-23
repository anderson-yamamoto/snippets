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
    public static void main(String[] args)
    {
        minimumNumberOfTrips(100, new int[]{5,10, 20, 30, 40, 50,55,65,75,77,81,88,90,97});
        //new int[]{70,10, 20, 30, 40, 50,35,45,15,22,31,40,90,27});
    }

    static int minimumNumberOfTrips(int tripMaxWeight, int[] packagesWeight)
    {
    	//(listOfWeights.size() + 2 -1)/2; //rounding division up
        int trips = 0;
        List<Integer> listOfWeights = new ArrayList<Integer>();
        for (int i = 0; i < packagesWeight.length; i++)
        {
            listOfWeights.add(packagesWeight[i]);
        }
        Collections.sort(listOfWeights);
        
        int minWeight = 0, maxWeight = listOfWeights.size() - 1; 
        for (maxWeight = listOfWeights.size() - 1; maxWeight >= 0; maxWeight--)
        {
        	if (minWeight == maxWeight) // finished, this package will be sent by itself
        	{
        		trips++; 
        		System.out.println("Trip: [" + listOfWeights.get(maxWeight) + "]");
        		break;
        	}
        		
        	if (listOfWeights.get(maxWeight) + listOfWeights.get(minWeight) <= tripMaxWeight) {
        		System.out.println("Trip: [" + listOfWeights.get(maxWeight) + ", " + listOfWeights.get(minWeight) + "]");
        		minWeight ++;
        	}
        	else{
        		System.out.println("Trip: [" + listOfWeights.get(maxWeight) + "]");	
        	}
        	trips++; // because this weight will need to be carried by itself, no other pair exists
        }        	
        System.out.println("Total trips: " + trips);
        return trips;
    }
}
