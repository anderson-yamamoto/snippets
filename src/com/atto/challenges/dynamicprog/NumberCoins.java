package com.atto.challenges.dynamicprog;

import java.util.Arrays;

public class NumberCoins
{
    
    /*
     * You have M types of coins available in infinite quantities where the value of each coin is given in the array. 
     * Can you determine the number of ways of making change C for N units using the given types of coins?
     * For example, if M=4, and C={8,3,2,1}, we can make change for N = 3 units in three ways: {1,1,1},{1,2} and {3}.
     * 
     */
    public static void main(String[] args)
    {
        int totalValue = 30;//N  
        
        int[] coinValues = new int[] {  3, 7, 10, 2 };// Array of coin values. Need to be ordered? no
        int numberOfCoins = coinValues.length; // M

        int[] header = new int[totalValue + 1]; //just to print

        int[][] results = new int[numberOfCoins][totalValue + 1]; //this will have the sum. we're adding +1 to make math easier

        for (int total = 0; total <= totalValue; total++)
        {
            header[total] = total;
            for (int coin = 0; coin < coinValues.length; coin++)
            {
                if (total == 0 || (coin == 0 && total % coinValues[coin] == 0)) //guaranteeing there is a sum when it is possible to match sum with only one coin, or when sum is zero
                    results[coin][total] = 1;
                else if (total >= coinValues[coin] && coin != 0){ 
                    //for example, result for coins {1,2,3} sum = 10 will be sum 10 coins {1,2} + sum 7 coins {1,2,3}  
                    int totalSubtractingCurrentCoin = results[coin][total - coinValues[coin]];
                    results[coin][total] = totalSubtractingCurrentCoin + results[coin - 1][total];
                }
                else if (coin != 0)
                    results[coin][total] = results[coin - 1][total];

            }
        }
        
        System.out.println(">>>");
        System.out.println(Arrays.toString(header));
        for (int coin = 0; coin < coinValues.length; coin++) 
            System.out.println(Arrays.toString(results[coin]));
        
        System.out.println("Total number of possibilities for " + totalValue + " coins: " + results[numberOfCoins - 1][totalValue]);

    }
}
