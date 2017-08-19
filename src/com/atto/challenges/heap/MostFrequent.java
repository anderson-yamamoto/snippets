package com.atto.challenges.heap;

import java.util.Arrays;
import java.util.HashMap;

public class MostFrequent
{

    /*
Given an integer array, find the most frequent number and it's count in the array. Write the
code in O(1) space. Eg 1 , 3, 4, 5, 2, 2, 3, 2 Output Most frequent number is 2. The
frequency is 3. Return the output as string in 'number: frequency' format. e.g. 2: 3 (Please
note the space after : and frequency. If multiple numbers have the same highest frequency
return the smallest number.
     */
    public static void main(String[] args)
    {
        int[] array = new int[]{23,61,63,15,73,36,3,67,11,63,11,11,15,99,45,16,8,63};
        ValueQuantity[] heap = new ValueQuantity[array.length + 1]; //using +1 because it's easier to count
        int firstFreeIndex = 1;
        
        HashMap<Integer,ValueQuantity> valueMap = new HashMap<Integer, ValueQuantity>();
        for (int i = 0; i < array.length; i++)
        {
            if(valueMap.containsKey(array[i])){
                ValueQuantity vq = valueMap.get(array[i]); 
                vq.increase();
                heapify(heap, vq.arrayIndex);
            }
            else
            {
                ValueQuantity v = new ValueQuantity(array[i]);
                valueMap.put(array[i], v);
                heap[firstFreeIndex] = v;
                v.arrayIndex = firstFreeIndex; 
                heapify(heap, firstFreeIndex);
                firstFreeIndex++;
            }
        }
        System.out.println(Arrays.toString(heap));
    }

    private static void heapify(ValueQuantity[] heap, int recentlyInsertedIndex)
    {
        if (recentlyInsertedIndex == 1) return;
        while (true){
            ValueQuantity current = heap[recentlyInsertedIndex];
            ValueQuantity father = heap[recentlyInsertedIndex/2];
            if (current.quantity > father.quantity || (current.quantity == father.quantity && current.value < father.value))
            {
                changePositions(heap, recentlyInsertedIndex, current, father); 
            }
            else return;
        }
    }

    private static void changePositions(ValueQuantity[] heap,
            int recentlyInsertedIndex, ValueQuantity current,
            ValueQuantity father)
    {
        heap[recentlyInsertedIndex] = father;
        father.arrayIndex =recentlyInsertedIndex; 
        heap[recentlyInsertedIndex/2] = current;
        current.arrayIndex = recentlyInsertedIndex/2;
    }
}

class ValueQuantity{
    public int value;
    public int quantity;
    public int arrayIndex;
    
    public ValueQuantity(int v){
        value = v;
        quantity = 1;
    }
    
    public void increase(){
        quantity++;
    }
    
    public String toString(){
        return value + "x" + quantity;
    }
}
