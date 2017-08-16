package com.atto.challenges.divisor;

// Find the number of integers 1 < n < 10^7, for which n and n + 1 have the 
// same number of positive divisors. 
// For example, 14 has the positive divisors 1, 2, 7, 14 while 15 has 1, 3, 5, 15.
public class ConsecutiveMatchingDivisors
{
    public static void main(String[] args)
    {
        int previousNumberDivisors = 1;
        int totalNumbers = 0;
        for (int i = 2; i < 1000000; i++)
        {
            int currentNumberDivisors = numberOfDivisors(i);
            if (previousNumberDivisors == currentNumberDivisors)
                totalNumbers++;
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
}
