package org.example;

import org.example.custom_sort.Merge;
import org.example.custom_sort.Quick;
import org.example.custom_sort.SortMethod;

public class Main {
    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void sortArray(int[] array, SortMethod sortMethod) {
        long startTime = System.currentTimeMillis();
        System.out.println("Before sorting:");
        printArray(array);
        
        sortMethod.sort(array);
        System.out.println("After sorting:");
        printArray(array);
        long endTime = System.currentTimeMillis();
        System.out.println("Sorting time: " + (endTime - startTime) + " ms");
        
        System.out.println("=====================================");
        
    }
    
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        int[] arr = {100, 20, 200, 15, 6,399, 299};
        SortMethod merge_sort_Method = Merge::merge_sort;
        sortArray(arr, merge_sort_Method);
        
        int[] arr2 = {100, 20, 200, 15, 6,399, 299};
        SortMethod quick_sort_Method = Quick::quick_sort;
        sortArray(arr2, quick_sort_Method);
    }
}