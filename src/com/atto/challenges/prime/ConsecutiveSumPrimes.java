package com.atto.challenges.prime;

import java.util.List;

/**

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
        int largestPrimeIndex = 0;
        List<Long> list = PrimeNumbers.getPrimes(78500);
        for (int i = list.size() - 1; i >= 0; i--)
        {
            if (list.get(i) < 1000000)
            {
                System.out.println("Last Prime before 1000000: " + i);
                largestPrimeIndex = i;
                break;
            }

        }

        int comboRecord = 0, winnerIndex = 0, comboCounter = 0;
        
        while (largestPrimeIndex > 0)
        {
            long sum = 0;
            for (int i = 0; i < list.size(); i++)
            {   
                sum += list.get(i);
                if (sum > list.get(largestPrimeIndex))
                {
                    if (comboCounter > comboRecord) //meaning a chance of breaking the record
                    {
                        int j = 0;
                        while (sum > list.get(largestPrimeIndex)) //removing shorter numbers
                        {
                            sum -= list.get(j);            
                            comboCounter--;    
                            j++;
                        }
                    }
                    else
                    {
                        largestPrimeIndex--;
                        comboCounter = 0;
                        break;
                    }
                }
                else if (sum == list.get(largestPrimeIndex)){
                    System.out.println("We're the champions!!!" + list.get(largestPrimeIndex) + " : COMBO " + comboCounter);
                    if (comboRecord < comboCounter){
                        comboRecord = comboCounter;
                        winnerIndex = largestPrimeIndex;
                    }
                    comboCounter = 0;
                    largestPrimeIndex--;
                    break;
                }
                comboCounter++;

            }
        }
        System.out.println("Record:" + comboRecord + ": " + list.get(winnerIndex));
    }
}
