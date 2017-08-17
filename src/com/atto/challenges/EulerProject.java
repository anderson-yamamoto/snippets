package com.atto.challenges;

public class EulerProject
{
    public static void main(String[] args)
    {
        
        System.out.println(multiples3and5());
        
    }
    
    //https://projecteuler.net/problem=1
    public static int multiples3and5(){
        int sum = 0;
        for (int i = 0; i < 1000; i++){
            if (i%3 == 0 || i%5 ==0)
                sum += i;
        }
        return sum;
    }
    
    //https://projecteuler.net/problem=6
    public static long getDifferenceSquareSumAndSumSquare(int lastNumber){
        long sum = (1 + lastNumber) * lastNumber/2;
        long difference = 0;
        for (int i = 1; i <= lastNumber; i++){
            difference += (sum - i) * i;
        }
        return difference;
    }
}
