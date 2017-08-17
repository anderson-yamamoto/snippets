package com.atto.challenges.prime;

import java.util.List;

/**
https://projecteuler.net/problem=50

The prime 41, can be written as the sum of six consecutive primes:

41 = 2 + 3 + 5 + 7 + 11 + 13
This is the longest sum of consecutive primes that adds to a prime below one-hundred.

The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most consecutive primes?
 */
public class ConsecutiveSumPrimes
{
    public static void main(String[] args)
    {
        
        List<Long> list = PrimeNumbers.getPrimesUpTo(1000000);
        int largestPrimeIndex = list.size() - 1;
        int comboRecord = 0, winnerIndex = 0, comboCounter = 0;
        
        while (largestPrimeIndex > 0)
        {
            long sum = 0;
            numberLoop: for (int i = 0; i < list.size(); i++)
            {   
                int removedPrimes = 0;
                sum += list.get(i);
                comboCounter++;
                if (sum > list.get(largestPrimeIndex))
                {
                    
                    while (sum > list.get(largestPrimeIndex)) //removing shorter numbers
                    {
                        sum -= list.get(removedPrimes);            
                        comboCounter--;  
                        
                        if (comboCounter == 0)
                        {
                            largestPrimeIndex--;
                            break numberLoop;
                        }
                        removedPrimes++;
                    }
                    
                }
                if (sum == list.get(largestPrimeIndex)){
                    System.out.println("Prime:" + list.get(largestPrimeIndex) + " : COMBO " + comboCounter);
                    if (comboRecord < comboCounter){
                        comboRecord = comboCounter;
                        winnerIndex = largestPrimeIndex;
                    }
                    comboCounter = 0;
                    largestPrimeIndex--;
                    break;
                }
            }
        }
        System.out.println("Record:" + comboRecord + ": " + list.get(winnerIndex));
    }
}
