package com.atto.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * A drone has an ID and a flight range. Return a list ordered by the highest flight range of N drones who are not in a maintenance list.
 * 
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
        list.add(new Drone(1, 1));
        list.add(new Drone(1, 15));
        greatestFlightRangeDrones(1, list, maintenance);
    }

    static List<Integer> greatestFlightRangeDrones(
            Integer numberOfRequiredDrones, List<Drone> drones,
            List<Integer> inMaintenanceDrones)
    {
        
        HashMap<Integer, Integer> maintenance = new HashMap<Integer, Integer> ();
        for (Integer i : inMaintenanceDrones)
            maintenance.put(i,i);
        
        Drone[] array = new Drone[drones.size()];
        int lastPosition = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (maintenance.get(drones.get(i).flight) != null)
                continue;
            if (lastPosition != 0)
            {
                int search = binarySearch(array, lastPosition,
                        drones.get(i).flight);
                if (search == -1 || search == lastPosition)
                    array[lastPosition++] = drones.get(i);
                else
                {
                    System.arraycopy(array, search, array, search + 1,
                            lastPosition - search);
                    array[search] = drones.get(i);
                    lastPosition++;
                }
            }
            else
            {
                array[lastPosition++] = drones.get(i);
            }
            System.out.println(Arrays.toString(array));
        }
        
        ArrayList<Integer> finalList = new ArrayList<Integer>();
        for (int i = 0; i < numberOfRequiredDrones; i++){
            finalList.add(array[i].id); 
        }
        return finalList;
    }

    private static int binarySearch(Drone[] array, int size, int flight)
    {
        int i = 0;
        for (; i < size; i++)
        {
            Drone search = array[i];
            if (search.flight < flight)
            {
                return i;
            }
        }
        return i;
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
