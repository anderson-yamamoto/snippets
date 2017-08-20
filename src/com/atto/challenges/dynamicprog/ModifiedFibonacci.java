package com.atto.challenges.dynamicprog;

import java.math.BigInteger;

/*
 * Given three integers, t1, t2, and n, compute and print term  of a modified Fibonacci sequence.
 * For example, if t1 = 0 and t2 = 1, then t3 = 0 + 1², t4 = 1 + 1². If n is 5, result is 1 + 1² = 4 
 */
public class ModifiedFibonacci
{
    public static void main(String[] args)
    {
        int position = 15;
        
        String[] terms = new String[position];
        terms[0] = "0";
        terms[1] = "1";
        for (int i = 2; i < position; i++){
            terms[i] = add(terms[i - 2], square(terms[i-1]));
        }
        System.out.println(terms[position - 1]);
    }
    
    public static String bigIntegerSolution(int position, String number0, String number1){
        BigInteger t1 = new BigInteger(number0);
        BigInteger t2 = new BigInteger(number1);
        BigInteger temp = new BigInteger("0");
        for(int i=3;i<=position;i++){
            temp = t2;
            t2 = t2.multiply(t2);
            t2 = t2.add(t1);
            t1 = temp;
        }
        return t2.toString();
    }
    
    public static String square(String number){
        String total = "0";
        for (int i = number.length() - 1; i >= 0 ; i--)
        {
            StringBuilder result = new StringBuilder(number.length() * 2);
            for (int k = i; k < number.length() - 1; k++ )
                result.append("0");
            
            int rest = 0;
            int multiplier = (number.charAt(i) - '0');
            for (int j = number.length() - 1; j >= 0 ; j--){
                int digit = (number.charAt(j) - '0');
                int multResult = digit * multiplier + rest;
                int lastDigit = multResult % 10; 
                result.append(lastDigit);
                rest = (multResult - lastDigit)/ 10;
            }
            if (rest != 0)
                result.append(rest);
            //System.out.println(result.reverse());
            total = add(total, result.reverse().toString());
            
        } 
        return total;
    }
    
    public static String add(String a, String b){
        StringBuilder result = new StringBuilder();
        int rest = 0;
        
        while (a.length() < b.length()){
           a = "0" + a;
        }
        while (a.length() > b.length()){
            b = "0" + a;
        }
        
        for (int j = a.length() - 1; j >= 0 ; j--){
            int firstDigit = (a.charAt(j) - '0');
            int secondDigit = (b.charAt(j) - '0');
            int addResult = firstDigit + secondDigit + rest;
            int lastDigit = addResult % 10; 
            result.append(lastDigit);
            rest = (addResult - lastDigit)/ 10;
        }
        
        if (rest != 0)
            result.append(rest);
        return result.reverse().toString();
    }
    
}
