package com.atto.challenges.heap;

import java.util.Arrays;


/*
 * Given an integer array A of size n. Given an integer k < n. 
 * Construct an array B, such that B[i] = min{A[i], A[i+1], A[i+2], 
 * A[i+3], ……., A[i+k]} Solve in time complexity better than O(nk). 
 */
public class MinLast3Array
{
    public static void main(String[] args)
    {
        int[] array = new int[]{23,61,63,15,73,36,3,67,11,63,58,52,15,99,45,16,8,63};
        int[] array2 = new int[array.length - 1];
        int[] array3 = new int[array.length - 2];
        
        //array3[0] = array2[0] = array[0];
        for (int i = 0; i < array2.length; i++){
            if (array[i] < array[i+1])
                array2[i] = array[i];
            else
                array2[i] = array[i+1];
        }
        
        for (int i = 0; i < array3.length; i++){
            if (array2[i] < array2[i+1])
                array3[i] = array2[i];
            else
                array3[i] = array2[i+1];
        }
        
        System.out.println(Arrays.toString(array3));
    }
}
