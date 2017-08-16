package com.atto.challenges.prime;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers
{
    //By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
    //What is the 10 001st prime number?
    public static void main(String[] args)
    {
        System.out.println(getPrimes(10001).get(10001 -1));
    }
    
    public static List<Long> getPrimes(int size){
        ArrayList<Long> list = new ArrayList<Long>(size);
        list.add(2L);
        list.add(3L);
        long currentNumber = 5;
        outer: while (list.size() != size){
            for (int i = 0; i < list.size(); i++){
                Long prime = list.get(i);
                if ( currentNumber%prime == 0){
                    currentNumber += 2;
                    continue outer;
                }
                
                if (prime > currentNumber/2)
                    break;
            }
            list.add(currentNumber);
            currentNumber += 2;
        }
        return list;
    }
}
