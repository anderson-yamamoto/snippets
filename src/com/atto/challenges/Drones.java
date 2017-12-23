package com.atto.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

/*
 * A drone has an ID and a flight range. Return a list ordered by the highest flight range of N drones who are not in a maintenance list.
 */
public class Drones
{
    public static void main(String[] args)
    {
        List<Drone> list = new ArrayList<Drone>();
        List<Integer> maintenance = new ArrayList<Integer>();
        maintenance.add(33);
        list.add(new Drone(1, 23));
        list.add(new Drone(1, 33));
        list.add(new Drone(1, 51));
        list.add(new Drone(1, 21));
        list.add(new Drone(1, 17));
        list.add(new Drone(1, 83));
        list.add(new Drone(1, 64));
        list.add(new Drone(1, 1));
        list.add(new Drone(1, 15));
        list.add(new Drone(1, 58));
        list.add(new Drone(1, 61));
        list.add(new Drone(1, 10));
        list.add(new Drone(1, 41));
        list.add(new Drone(1, 31));
        list.add(new Drone(1, 15));
        greatestFlightRangeDrones(1, list, maintenance);
    }

    static List<Drone> greatestFlightRangeDrones(
            Integer numberOfRequiredDrones, List<Drone> drones,
            List<Integer> inMaintenanceDrones)
    {
        
        HashMap<Integer, Integer> maintenance = new HashMap<Integer, Integer> ();
        TreeSet<Drone> list = new TreeSet<Drone> (new Comparator<Drone>(){
			@Override
			public int compare(Drone o1, Drone o2) {
				return Integer.compare(o1.flight, o2.flight);
			}
        	
        });
        for (Integer i : inMaintenanceDrones)
            maintenance.put(i,i);
        
        for (int i = 0; i < drones.size(); i++)
        {
            if (maintenance.get(drones.get(i).flight) != null)
                continue;
            list.add(drones.get(i));
            System.out.println(Arrays.toString(list.toArray()));
        }
        
        return new ArrayList<Drone>(list);
    }

    // Unused method for binary searching insert point  
    @SuppressWarnings("unused")
	private static int binarySearch(Drone[] array, int flight)
    {
    	if (array[0].flight > flight)
    		return 0;
    	if (array[array.length - 1].flight < flight)
    		return array.length ;
        return binarySearch(array, flight, 0, array.length);
    }
    
    //Unused method for binary searching insert point
    private static int binarySearch(Drone[] array, int flight, int start, int end)
    {
        int pivot = start + (end - start) /2;
        if (start == pivot)
        {
        	if (array[pivot].flight < flight)
        		return pivot + 1;
        	return pivot;
        }
        	
        if (array[pivot].flight == flight)
        	return pivot;
        if (array[pivot].flight > flight)
        	return binarySearch(array, flight, start, pivot);
    	return binarySearch(array, flight, pivot, end);
    }

}

class Drone
{
    int id;
    int flight;

    public Drone(int id, int flight)
    {
        this.id = id;
        this.flight = flight;
    }

    public String toString()
    {
        return String.valueOf(flight);
    }
}
