package org.example.custom_sort;

public class Quick {
    public static void quick_sort(int[] to_sort) {
        quick_sort(to_sort, 0, to_sort.length - 1);
    }

    public static void quick_sort(int[] to_sort, int low, int high) {
        if (low >= high || low < 0) {
            return;
        }
        int pivot = partition(to_sort, low, high);
        quick_sort(to_sort, low, pivot - 1);
        quick_sort(to_sort, pivot + 1, high);
    }

    public static int partition(int[] to_sort, int low, int high) {
        int pivot = to_sort[low];
        int left_i = low - 1;
        int right_i = high + 1;
        while (true) {
            // find the first element from the left that is greater than the pivot
            do {
                left_i++;
            } while (to_sort[left_i] < pivot);
            // find the first element from the right that is less than the pivot
            do {
                right_i--;
            } while (to_sort[right_i] > pivot);

            // if the left index is greater than or equal to the right index, return the right index
            if (left_i >= right_i) {
                return right_i;
            }

            // swap the elements at the left and right indices
            int temp = to_sort[left_i];
            to_sort[left_i] = to_sort[right_i];
            to_sort[right_i] = temp;
        }
    }
}
