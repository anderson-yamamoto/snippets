package com.atto.challenges.divisor;

import java.util.List;

import com.atto.challenges.prime.PrimeNumbers;

// Find the number of integers 1 < n < 10^7, for which n and n + 1 have the 
// same number of positive divisors. 
// For example, 14 has the positive divisors 1, 2, 7, 14 while 15 has 1, 3, 5, 15.
public class ConsecutiveMatchingDivisors
{
    public static void main(String[] args)
    {
        List<Long> primeNumbers = PrimeNumbers.getPrimes(40000);
        
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
    }
    
    public static int numberOfDivisors(int number){
        int numberDivisors = 2;
        boolean even = number%2 == 0;
        if (even){
            numberDivisors += 2;
            for (int i = 3; i <= number/3; i++){
                if (number%i == 0)
                    numberDivisors++;
            }
        }else{
            for (int i = 3; i <= number/3; i+= 2){
                if (number%i == 0)
                    numberDivisors++;
            }
        }
        
        return numberDivisors;
    }//need to decompose into prime multipliers and calculate combinations instead, should be faster
    
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
