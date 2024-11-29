package org.example.custom_sort;

public class Merge {
    static void fillArray(int[] array,
                          int[] aux_array,
                          int start, int end, 
                          int offset,
                          int array_i) {
        while (start <= end) {
            array[array_i] = aux_array[start - offset];
            start++;
            array_i++;
        }
    } 
    static void merge(int[] to_sort, int low, int middle, int high) {
        int[] helper = new int[high - low + 1];
        System.arraycopy(to_sort, low, helper, 0, high - low + 1);
        int i = low;
        int j = middle + 1;
        int k = low;

        while (i <= middle && j <= high) {
            if (helper[i - low] <= helper[j - low]) {
                to_sort[k] = helper[i - low];
                i++;
            } else {
                to_sort[k] = helper[j - low];
                j++;
            }
            k++;
        }
        fillArray(to_sort, helper, i, middle, low, k);
        fillArray(to_sort, helper, j, high, low, k);
    }

    static void merge_sort(int[] to_sort, int low, int high) {
        int middle = (low + high) / 2;
        if (low >= high) {
            return;
        }
        merge_sort(to_sort, low, middle);
        merge_sort(to_sort, middle + 1, high);
        merge(to_sort, low, middle, high);
    }

    public static void merge_sort(int[] to_sort) {
        int low = 0;
        int high = to_sort.length - 1;
        if (low >= high) {
            return;
        }
        int middle = (low + high) / 2;
        merge_sort(to_sort, low, middle);
        merge_sort(to_sort, middle + 1, high);
        merge(to_sort, low, middle, high);
    }
}
