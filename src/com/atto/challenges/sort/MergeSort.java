package com.atto.challenges.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{23,61,63,15,73,36,3,67,11,63,58,52,15,99,45,16,8,63};
        System.out.println("Before:" + Arrays.toString(array));
        sort(array, 0, array.length);
        System.out.println("After:" + Arrays.toString(array));
    }
    
    
    public static void sort(int[] array, int beginning, int length){
        if (length > 1)
        {
            int breakingPoint = length /2;
            sort(array, beginning, breakingPoint);
            sort(array, beginning + breakingPoint, length - breakingPoint);
            merge(array, beginning , breakingPoint, beginning + breakingPoint, length - breakingPoint);
        }
    }
    
    public static void merge(int[] array, int beginningfirstArray, int lengthFirstArray, int beginningSecondArray, int lengthSecondArray){
        int[] first = new int[lengthFirstArray];
        int[] second= new int[lengthSecondArray];
        System.arraycopy(array, beginningfirstArray, first, 0, lengthFirstArray);
        System.arraycopy(array, beginningSecondArray, second, 0, lengthSecondArray);
        
        int firstIndex = 0, secondIndex = 0;
        for (int i = beginningfirstArray; i < beginningfirstArray + lengthFirstArray + lengthSecondArray; i++) {
            if (secondIndex == second.length){
                array[i] = first[firstIndex];
                firstIndex++;
            }else if (firstIndex == first.length || first[firstIndex] > second[secondIndex])
            {
                array[i] = second[secondIndex];
                secondIndex++;
            }
            else
            {
                array[i] = first[firstIndex];
                firstIndex++;
            }
        }
        System.out.println(Arrays.toString(array));
        
    }
}


