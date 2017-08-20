package com.atto.challenges;
import java.util.Arrays;
/*
 A swap operation M on an array is defined where you can only swap the
 adjacent elements. Given an array containing digits and n swap
 operations(defined as below), maximize the value of the array.
 */
public class SwapMaximumArrayValue
{
    public static void main(String[] args)
    {
        int[] array = new int[]{7,2,3,6,8,6,5};
        calculateSwaps(array, 4);
        System.out.println(Arrays.toString(array));
    }

    private static void calculateSwaps(int[] array, int numberOfSwaps)
    {
        int index = 0;
        while (numberOfSwaps > 0 && index < array.length){
            int biggestElement = 0, biggestIndex = 0;
            for (int i = index; i < Math.min(index+numberOfSwaps, array.length) ;i++){
                if (array[i] > biggestElement)
                {
                    biggestElement = array[i];
                    biggestIndex = i;
                }
            }
            while (biggestIndex > index){
                swap(array, --biggestIndex);
                numberOfSwaps--;
            }
            index++;
        }
        
    }
    
    private static void swap(int[] array, int index){
        int temp = array[index];
        array[index] = array[index + 1];
        array[index + 1] = temp;
    }
    
}
