package com.atto.challenges;

public class EulerProject
{
    public static void main(String[] args)
    {
        
        System.out.println(pandigital());
        
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
    
    //https://projecteuler.net/problem=38
    public static int pandigital(){
        int biggest = 0, biggestIntGenerated = 0;
        String biggestPandigital = "";
        for (int i = 9999; i > 1; i--)
        {
            StringBuilder pandigital = new StringBuilder();
            int multiplier = 1;
            pandigital.append(i*multiplier);
            while (pandigital.length() < 9){
                multiplier++;
                pandigital.append(i*multiplier);
            }
            if (pandigital.length() == 9 && !checkValidPandigital1to9(pandigital)){
                System.out.println(pandigital + "-" + i);
                int p = Integer.parseInt(pandigital.toString());
                if (p > biggest){
                    biggest = p;
                    biggestIntGenerated = i;
                    biggestPandigital = pandigital.toString();
                }
            }
        }
        System.out.println(biggestPandigital + "-" + biggestIntGenerated);
        return biggest;
    }

    private static boolean checkValidPandigital1to9(StringBuilder pandigital)
    {
        for (int i = 0; i < pandigital.length(); i++){
            if (pandigital.charAt(i) == '0')
                return true;
            for (int j = i+1; j < pandigital.length(); j++){
                if (pandigital.charAt(i) == pandigital.charAt(j))
                    return true;
            }
        }
        return false;
    }
}
