package com.atto.challenges.multiples;
import java.util.HashMap;


public class MultiplesOf3WithAll1
{
    /*
     * A number ending with 3 will have a multiple which is all 1. Eg­ multiple of 3 is 111 and of
     * 13 is 111111. Given a number ending with 3 find its least multiple which is all 1. The
     * 2 multiple of the given number can be beyond the range of int,long etc. Optimize for time.
     */
    public static void main(String[] args)
    {
        HashMap<Integer, Integer> map = multiplier();
        HashMap<Integer, Integer> previousRests = new HashMap<Integer, Integer>();
        StringBuilder builder = new StringBuilder();
        int number = 113; 
        int limiter = 0;
        int previousRest = 0;
        int nextMultiplier = 7;
        while ( ++limiter< 200){
            builder.append(nextMultiplier);
            int total = number * nextMultiplier + previousRest;
            System.out.println(total);
            previousRest = (total - 1) / 10;
            if (previousRest == 11 || previousRest == 111){
                System.out.println("Found number! : " + builder.reverse() + " * " + number);
                break;
            }
            
            Integer checkIfLoop = previousRests.get(previousRest);
            if (checkIfLoop == null){
                previousRests.put(previousRest, previousRest);
            }
            else{
                System.out.println("Infinite looping. Impossible to calculate. ");
                break;
            }
            try{
                int lastDigitPreviousRest = previousRest% 10; 
                if (lastDigitPreviousRest == 0)
                    nextMultiplier = map.get(1);
                else if (lastDigitPreviousRest == 1)
                    nextMultiplier = map.get(0);
                else
                    nextMultiplier = map.get(11 - (previousRest% 10));
            }catch(Exception e){
                System.out.println("Error--" + previousRest + "-" + (11 - (previousRest% 10)));
            }
        }
    }
  
    
    public static HashMap<Integer, Integer> multiplier(){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 7);
        map.put(2, 4);
        map.put(3, 1);
        map.put(4, 8);
        map.put(5, 5);
        map.put(6, 2);
        map.put(7, 9);
        map.put(8, 6);
        map.put(9, 3);
        map.put(0, 0);
        return map;
    }
}
