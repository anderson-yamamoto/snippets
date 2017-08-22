package com.atto.challenges.divisor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.atto.challenges.prime.PrimeNumbers;

// https://projecteuler.net/problem=179
// Find the number of integers 1 < n < 10^7, for which n and n + 1 have the 
// same number of positive divisors. 
// For example, 14 has the positive divisors 1, 2, 7, 14 while 15 has 1, 3, 5, 15.
public class ConsecutiveMatchingDivisors
{
    public static void main(String[] args) throws IOException
    {
        List<Long> primeNumbers = PrimeNumbers.getPrimesUpTo(1000000);
        int precisely2PrimeFactors = 0;
        int previousNumberDivisors = 2;
        int totalNumbers = 0;
        for (int i = 3; i < 1000001; i++)
        {
            int currentNumberDivisors = numberOfDivisors(i, primeNumbers);
            if (previousNumberDivisors == currentNumberDivisors)
            {
                totalNumbers++;
                System.out.println(totalNumbers + "::" + i + "- " + previousNumberDivisors + "-" + currentNumberDivisors);
            }
            previousNumberDivisors = currentNumberDivisors;
        }
        System.out.println(totalNumbers);
        FileOutputStream f = new FileOutputStream("result.txt");
        f.write(String.valueOf(totalNumbers).getBytes());
        f.flush();
        f.close();
    }
    
    /*
     * to calculate: n = a^x * b^y * c^z
       where a, b, and c are n's prime divisors and x, y, and z are the number of times that divisor is repeated) then the total count for all of the divisors is:
       (x + 1) * (y + 1) * (z + 1).
     */
    public static int numberOfDivisors(int number, List<Long> primeNumbers){
        int totalOfPrimeDivisors = 1;
        int totalForSingleDivisor = 1;
        int total = number; 
        for (Long lg : primeNumbers){
            if (lg > number/2) break;
            totalForSingleDivisor = 1;
            while (total % lg == 0){ total /= lg; totalForSingleDivisor++;}
            totalOfPrimeDivisors *= totalForSingleDivisor;
        }
      
        return (totalOfPrimeDivisors == 1) ? 2 : totalOfPrimeDivisors; //if totalOfPrimeDivisors == 1 then it's a prime number so it has two divisors
    }
}
