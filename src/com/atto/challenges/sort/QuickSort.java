package com.atto.challenges.sort;

import java.util.Arrays;

public class QuickSort
{
    public static void main(String[] args)
    {
        int[] array = new int[] { 23, 61, 63, 15, 73, 36, 3, 67, 11, 63, 58,
                52, 15, 99, 45, 16, 8, 63 };
        System.out.println(Arrays.toString(array));
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array, int beginning, int end) {
        if (beginning >= end) return;
        int left = beginning, right = end;
        int pivot = array[(beginning + end)/2];
        System.out.println("Pivot:" + pivot + " \t"+ beginning + "_" + end );
        while (left <= right){
            while (array[left] < pivot) left++;
            while (array[right] > pivot) right--;
            
            if (left <= right){
                System.out.println("switching " + array[left] + "-" + array[right]);
                switchPosition(array, left, right);
                left++;
                right--;
            }
            System.out.println(Arrays.toString(array));
        }
        
        sort(array, beginning, right);
        sort(array, left, end);
    }

    private static void switchPosition(int[] array, int up, int down)
    {
        int temp = array[up];
        array[up] = array[down];
        array[down] = temp;
    }
}
