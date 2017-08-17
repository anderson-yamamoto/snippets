package com.atto.challenges.prime;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers
{

    public static void main(String[] args)
    {
        long l = System.currentTimeMillis();
        List<Long> list = getPrimesUpTo(1000);
        System.out.println(list);
        System.out.println(System.currentTimeMillis() - l);
    }

    /*
     * The prime factors of 13195 are 5, 7, 13 and 29. What is the largest prime
     * factor of the number 600851475143 ?
     */
    public static Long getLargestPrimeFactor(long number)
    {
        List<Long> list = getPrimes(100000);
        long total = number;
        long biggest = 0;
        for (Long lg : list)
        {
            if (lg > number / 2)
                break;
            while (total % lg == 0)
            {
                total /= lg;
                biggest = lg;
            }
        }
        System.out.println("Total after running: " + total);
        return biggest;
    }

    // By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can
    // see that the 6th prime is 13.
    // What is the 10 001st prime number?
    public static Long get10001PrimeNumber()
    {
        return getPrimes(10001).get(10001 - 1);
    }

    //very inneficient 
    public static List<Long> getPrimes(int size)
    {
        ArrayList<Long> list = new ArrayList<Long>(size);
        list.add(2L);
        list.add(3L);
        long currentNumber = 5;
        outer: while (list.size() != size)
        {
            for (int i = 0; i < list.size(); i++)
            {
                Long prime = list.get(i);
                if (currentNumber % prime == 0)
                {
                    currentNumber += 2;
                    continue outer;
                }

                if (prime > currentNumber / 2)
                    break;
            }
            list.add(currentNumber);
            currentNumber += 2;
        }
        return list;
    }

    // Execution time for number = 1mi: 78498 prime numbers, 164ms
    // Implemented using Sieve of Eratosthenes
    public static List<Long> getPrimesUpTo(int number)
    {
        int NOT_PRIME = -1;
        ArrayList<Long> list = new ArrayList<Long>(number);

        int[] flags = new int[number + 1];
        for (int i = 2; i < number; i++)
        {
            if (flags[i] != NOT_PRIME)
            {
                for (int j = 2; j <= (number / i); j++)
                    flags[i * j] = NOT_PRIME;
                list.add((long) i);
            }
        }
        return list;
    }
}
