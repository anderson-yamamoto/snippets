package com.atto.challenges.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[] { 23, 61, 63, 15, 73, 36, 3, 67, 11, 63, 58, 52, 15, 99, 45, 16, 8, 63 };
        System.out.println("Before:" + Arrays.toString(array));
        sort(array, 0, array.length);
        System.out.println("After:" + Arrays.toString(array));
    }

    public static void sort(int[] array, int beginning, int length) {
        if (length > 1) {
            int breakingPoint = pivot(array, beginning, length);
            sort(array, beginning, breakingPoint);
            sort(array, beginning + breakingPoint, length - breakingPoint);
        }
    }

    private static int pivot(int[] array, int beginning, int length) {
        
        return beginning;
    }
}
